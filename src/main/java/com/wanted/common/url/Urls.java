package com.wanted.common.url;

public interface Urls {

    String API = "api";
    String SERVICE_NAME = "wanted";
    String ROOT = "/" + API + "/" + SERVICE_NAME;

    interface Insurance {
        String PART = "insurance";
        String FULL = ROOT + "/" + PART;

        interface SendingList {
            String PART = "getDateForSendingList";
            String FULL = ROOT + "/" + PART;
        }
    }

    interface Money {
        String PART = "money";
        String FULL = ROOT + "/" + PART;

        interface StringValue {
            String PART = "getStringValue/{number}";
            String FULL = ROOT + "/" + PART;
        }
    }

    interface Employee {
        String PART = "employee";
        String FULL = ROOT + "/" + PART;

        interface Relatives {
            String PART = "relatives/{personId}";
            String FULL = ROOT + "/" + PART;
        }
    }
}
