package com.example.shoppingmall.interfaces.external;

import com.example.shoppingmall.domain.enums.SignUpType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

@Setter
@Getter
@Builder
public class OAuthDto {

    private String providerId;
    private SignUpType signUpType;
    private String name;
    private String phoneNumber;

    public static OAuthDto of(String provider, OAuth2User oAuth2User) {
        var signUpType = SignUpType.valueOf(provider.toUpperCase());
        OAuthDto oAuthDto = null;
        switch (signUpType) {
            case KAKAO -> oAuthDto = ofKakao(oAuth2User);
            case NAVER -> oAuthDto = ofNaver(oAuth2User);
            case GOOGLE -> oAuthDto = ofGoogle(oAuth2User);
        }
        return oAuthDto;
    }

    private static OAuthDto ofKakao(OAuth2User oAuth2User) {
        var providerId = oAuth2User.getAttributes().get("id").toString();
        var properties = (Map) oAuth2User.getAttributes().get("properties");
        var name = properties.get("nickname").toString();
        return OAuthDto.builder()
                .signUpType(SignUpType.KAKAO)
                .providerId(providerId)
                .name(name)
                .build();
    }

    private static OAuthDto ofNaver(OAuth2User oAuth2User) {
        var properties = (Map) oAuth2User.getAttributes().get("response");
        var providerId = properties.get("id").toString();
        var name = properties.get("name").toString();
        var phoneNumber = properties.get("mobile_e164").toString();
        return OAuthDto.builder()
                .signUpType(SignUpType.NAVER)
                .providerId(providerId)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }

    private static OAuthDto ofGoogle(OAuth2User oAuth2User) {
        var attributes = oAuth2User.getAttributes();
        var providerId = attributes.get("sub").toString();
        var name = attributes.get("name").toString();
        return OAuthDto.builder()
                .signUpType(SignUpType.GOOGLE)
                .providerId(providerId)
                .name(name)
                .build();

    }



}
