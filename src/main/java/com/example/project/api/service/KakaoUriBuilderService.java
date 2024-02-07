package com.example.project.api.service;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import org.springframework.http.HttpHeaders;

@Slf4j
@Service
public class KakaoUriBuilderService {

    private static final String KAKAO_LOCAL_SEARCH_ADDERSS_URL = "https://dapi.kakao.com/v2/local/search/address.json";

    public URI buildUriByAddressSearch (String address) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_SEARCH_ADDERSS_URL);
        uriBuilder.queryParam("query", address);

        URI uri = uriBuilder.build().encode().toUri();

        log.info("[KakaoUriBuilderService buildUriByAddressSearch] address: {}, uri: {}", address, uri);

        return uri;

    }
}
