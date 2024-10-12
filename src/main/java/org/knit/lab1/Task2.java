package org.knit.lab1;

public class Task2 {
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String path;
    private String webpageName;
    private String webPageExtension;
    private String queryString;

    public Task2(String url) {
        parseUrl(url);
    }

    private void parseUrl(String url) {
        try {
            String[] protocolSplit = url.split("://");
            this.protocol = protocolSplit[0];

            String[] addressAndPath = protocolSplit[1].split("/", 2);
            String address = addressAndPath[0];
            this.address = address;

            String[] domainParts = address.split("\\.");
            this.siteName = domainParts[0];
            this.domainZone = domainParts[domainParts.length - 1];

            if (addressAndPath.length > 1) {
                String[] pathAndQuery = addressAndPath[1].split("\\?", 2);
                this.path = pathAndQuery[0];

                String[] pathParts = path.split("/");
                String lastPart = pathParts[pathParts.length - 1];
                String[] webpageParts = lastPart.split("\\.");
                this.webpageName = webpageParts[0];
                this.webPageExtension = webpageParts[1];

                if (pathAndQuery.length > 1) {
                    this.queryString = pathAndQuery[1];
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при парсинге URL: " + e.getMessage());
        }
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public String getWebPageExtension() {
        return webPageExtension;
    }

    public void setWebPageExtension(String webPageExtension) {
        this.webPageExtension = webPageExtension;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    @Override
    public String toString() {
        return "protocol = " + protocol + "\n" +
                "address = " + address + "\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" +
                "path = " + path + "\n" +
                "webpageName = " + webpageName + "\n" +
                "webPageExtension = " + webPageExtension + "\n" +
                "queryString = " + queryString;
    }

    public static void main(String[] args) {
        String url = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        Task2 simpleUrl = new Task2(url);
        System.out.println(simpleUrl);
    }
}