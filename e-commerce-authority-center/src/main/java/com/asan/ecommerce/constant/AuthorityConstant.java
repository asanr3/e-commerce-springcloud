package com.asan.ecommerce.constant;

/**
 * <h1>授权需要使用的一些常量信息</h1>
 * @author mingkai yun
 * @date 2022/1/12
 */
public class AuthorityConstant {

    /** RSA 私钥, 除了授权中心以外, 不暴露给任何客户端 */
    public static final String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCbatJhkEPVtWam7Q29Qslg" +
            "ABaKtED3ZmhixkSkB0A38zFPw0WoRVhHejVimNX6lHEyMgFcqYxDy0G4w+9owTzDM/fX+MGNhpb2zIIM6vWwjRP+qC0vEaRgu23MTAWi19" +
            "3P868QmKnM8m7qrYIBK1HYRQprlH/ccr46I9oDSs9zPju1129rBWV85iNgdL4UeZwy6sqDGShAwWj7UCwJS91FFceO1nolhS4dCfIH5G" +
            "p4QTV8AWeeLmGdmMEc6gegseXj39WdylMnvDZ7+TlX5wsUPxntDs+iIprzSPGkP17u0hFYbjxRyQrcrLTD22l/aUOV2OjLu/lr1yf6EY" +
            "mfyrL7AgMBAAECggEAYPV1prRP/aWcEwvVBHwEEcY8SfBGj5HuEaFL9WEoqT8pRm+2p1ILzxvo7kgXRqsRK5WSz/JetXS63cAvPhVACTA" +
            "EsVJZvid3SyUvBUwYVzrMfJUDC1hgSpDj4Q6UfZFaqn+Gej4jwN6GYBY7Auu5tcjsxUzxr+BN2QvA2Uj0vxna+umswG7o/ZkC+wOALBnMS" +
            "eVwWeUJzzKGlnJq5zVdYB9r5Tf2v/0fuuFOSa/7AptR/kbUm2iRQGbPs4l4Yw6CKuHUTtGncp8qVFziSxORVph3SWYHBkrw5CGnL26/wHG" +
            "yWLEJ2EnGgy9YrQsYlZrqbodIJ5/V1xolBnzr8+rMEQKBgQDk7qEwTflPG0iD4tN7dN2y16KCgjjJiCANw5MdvoA7PmqyS7DHxRUwiHxTJ" +
            "pn5A7WkP7z7v0aGZo8kVAdjXKHL5iTrGyVNLB9qtKqZRFyEkX7hWOwBwn1YESg+/zJi0gfMKaj57SD93WL4IlbSHgXu656cpgmG4EKpDnS" +
            "sUeciDwKBgQCtywb2lO2sb83ICfFilW2miar4c4zIiTFHufetpRgq45ZiDz3qbaMY3feEY3MDGirWvQ6rMjYbJkHALxmkOZnUiC4ngQRU1" +
            "gpwKn3Bn+usYM2iK5a/nvD9nSy8gXlvk3ul9IGySXwXYo5GJuXYJ9MbgK3wieDMCd7t8SXoyEFcVQKBgG5PmfXnrJj0oZWDR7o2TtltVE4" +
            "kp25cnG1lbs8nSyzA37K4DB/GlHZFXfrHH+xAYFcbq1l3Cmmao6CyqLi1GvVgGSv8cZXlC+Jj2cxuh1INtaCqM1aJu9IiukzYtROu9rjm3" +
            "hhHrd0FvzmnekRW2S8N8+ixjOejyhsh7xBVitT7AoGAe/0xBpLRzggl4+VUFWVOSVZGZ+LoOdnHEskWbwgt6ctc6rC9F5cImSEjCYx57W" +
            "ipz3IqGPFFsLDmj9oKjSObIAnYA88D7BKYd9WYyp7xYJXfnydB8YvPmuCbnhExNe0edhOuxCexJG3n2xy9Ni2Tazeu4ME9Y9RW+6LjzOO" +
            "x3dECgYEAr3ZzNA/2IhnxFqecrLQACGp/k4X/F+duG7VzyBGdHeS+P/hidt8WnzGXzLfTZbVPZ+hjqImreiU6s5hFC+Ezw0CEkMIFDRLM" +
            "VogqacXhfI7U+2JbK/7JXl5EH8AEavnP/Mr5vapNAZy949BCWVXlygayj/8+TyNyKrPhHEVE3OQ=";

    /** 默认的 Token 超时时间, 一天 */
    public static final Integer DEFAULT_EXPIRE_DAY = 1;
}
