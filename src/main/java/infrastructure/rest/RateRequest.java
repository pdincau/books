package infrastructure.rest;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RateRequest {

    private String userId;
    private Integer rate;
    private String description;

    public String getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
