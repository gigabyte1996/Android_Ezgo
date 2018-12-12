package com.example.laptop88.ezgo.Utils;

import retrofit2.http.PUT;

public class Constants {
    public static String BASE_URL = "http://10.0.129.56:8080";

    public static String SHARED_PREFERENCES_NAME = "ticket";

    public class SeatStatusColor{
        public static final String PICKING = "#35950C";
        public static final String RESERVED = "#E16606";
        public static final String EMPTY ="#FFFFFF";
        public static final String TRADING = "#CFBC05";
    }
    public class SeatStatus{
        public static final int PICKING = 0;
        public static final int RESERVED = 1;
        public static final int EMPTY = 2;
        public static final int TRADING = 3;
    }

    public class HTTPCodeResponse {
        public static final int SUCCESS = 0;
        public static final int OBJECT_EXISTED = 302;
        public static final int OBJECT_NOT_FOUND = 404;
        public static final int UNAUTHORIZED = 401;
    }

    public final class VisibilityType {
        public static final int GONE = 8;
        public static final int INVISIBLE = 4;
        public static final int VISIBLE = 0;
    }



    public class CarrageType{
        public static final int SOFT_SEAT = 0;
        public static final int HARD_SEAT = 1;
        public static final int SOFT_BED = 2;
        public static final int HARD_BED = 3;

    }
}
