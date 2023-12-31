package org.choongang.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 특정 역할을 분담하는 클래스
 *  : 파일 업로드 설정에 필요한 데이터 클래스
 */
@Data
@ConfigurationProperties(prefix = "file")   // 설정 파일에 있는 property를 클래스에 값을 가져와서(바인딩) 사용할 수 있게 해주는 어노테이션
public class FileProperties {

    private String url ;    // file.url(/upload/)으로 자동완성
    private String path ;   // file.path(C:/uploads/)로 자동완성
}
