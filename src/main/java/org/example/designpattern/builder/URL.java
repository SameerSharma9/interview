package org.example.designpattern.builder;

import lombok.ToString;

public class URL {
    private String protocol;
    private String hostname;
    private String port;
    private String path;
    private String queryParam;

    public URL(UrlBuilder builder) {
        this.protocol = builder.protocol;
        this.hostname = builder.hostname;
        this.port = builder.port;
        this.path = builder.path;
        this.queryParam = builder.queryParam;
    }

    public static class UrlBuilder {
        private URL url;
        private String protocol;
        private String hostname;
        private String port;
        private String path;
        private String queryParam;

        public UrlBuilder() {}

        public UrlBuilder(String hostname, String port, String path) {
            this.hostname = hostname;
            this.port = port;
            this.path = path;
        }

        public UrlBuilder protocol(String protocol) {
            this.protocol = protocol+"://";
            return  this;
        }

        public UrlBuilder hostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        public UrlBuilder port(Integer port) {
            this.port = ":"+port;
            return this;
        }

        public UrlBuilder path(String path) {
            this.path = "/"+path;
            return this;
        }

        public  UrlBuilder queryParam(String param) {
            this.queryParam = "?"+param;
            return this;
        }

        public URL build() {
            URL url = new URL(this);
                return url;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if(protocol!=null) s.append(protocol);
        if(hostname!=null) s.append(hostname);
        if(port!=null) s.append(port);
        if(path!=null) s.append(path);
        if(queryParam!=null) s.append(queryParam);
        return s.toString();
    }

    public static void main(String[] args) {
        URL url = new UrlBuilder()
                .protocol("http")
                .hostname("google.com")
                .port(9090)
                .path("search")
                .queryParam("address")
                .build();
        System.out.println(url.toString());
        URL url2 = new UrlBuilder()
                .hostname("amazon.ca")
                .port(8081)
                .path("product")
                .build();
        System.out.println(url2.toString());
    }
}
