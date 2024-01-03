package com.example.shoppingmall.service.users;

import com.example.shoppingmall.domain.users.CustomUserDetails;
import com.example.shoppingmall.interfaces.external.OAuthDto;
import com.example.shoppingmall.interfaces.users.UsersDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UsersDtoMapper usersDtoMapper;
    private final UsersService usersService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        var oAuth2User = super.loadUser(userRequest);
        var oAuthDto = OAuthDto.of(userRequest.getClientRegistration().getRegistrationId(), oAuth2User);
        var users = usersService.getUsers(oAuthDto.getProviderId());

        // 미가입자 회원가입
        if (users == null) {
            var providerId = oAuthDto.getProviderId();
            var signUpType = oAuthDto.getSignUpType();
            var name = oAuthDto.getName();
            var phoneNumber = oAuthDto.getPhoneNumber();

            var command = usersDtoMapper.of(providerId, signUpType, name, phoneNumber);
            var oauthUsers = command.toEntityByOath2();
            users = usersService.signUp(oauthUsers);
        }
        return new CustomUserDetails(users.getAuthority(), null, users.getName(), users.getUid());
    }

}
