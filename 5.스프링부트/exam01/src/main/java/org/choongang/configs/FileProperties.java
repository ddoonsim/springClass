package org.choongang.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 파일 업로드 설정에 필요한 데이터 클래스
 */
@Data
@ConfigurationProperties(prefix = "file")   //
public class FileProperties {

    private String url ;    // file.url(/upload/)으로 자동완성
    private String path ;   // file.path(C:/uploads/)로 자동완성
}
