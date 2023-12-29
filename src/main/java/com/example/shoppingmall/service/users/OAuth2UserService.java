package com.example.shoppingmall.service.users;

import com.example.shoppingmall.domain.enums.SignUpType;
import com.example.shoppingmall.domain.users.CustomUserDetails;
import com.example.shoppingmall.interfaces.users.UsersDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UsersDtoMapper usersDtoMapper;
    private final UsersService usersService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        var oAuth2User = super.loadUser(userRequest);
        var uid = oAuth2User.getAttributes().get("id").toString();  // oauth2 인증 플랫폼의 id ( 이걸로 우리 서비스 uid 사용)
        var users = usersService.getUsers(uid);

        // 미가입자 회원가입
        if (users == null) {
            var properties = (Map) oAuth2User.getAttributes().get("properties");
            var name = properties.get("nickname").toString();
            var command = usersDtoMapper.of(uid, SignUpType.KAKAO, name);
            var oauthUsers = command.toEntityByOath2();
            users = usersService.signUp(oauthUsers);
        }
        return new CustomUserDetails(users.getAuthority(), null, users.getName());
    }

}
