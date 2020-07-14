package io.quind.calculatorsalary.util;

import org.springframework.http.HttpHeaders;

public class ApiHeaders {

    public static HttpHeaders getHeaders() {
        HttpHeaders result = new HttpHeaders();
        result.set("Cache-Control","no-store, no-cache, must-revalidate");
        result.set("Pragma","no-cache");
        result.setDate("Expires", 0);
        result.set("X-FRAME-OPTIONS", "ALLOW-FROM localhost");

        return result;
    }
}
