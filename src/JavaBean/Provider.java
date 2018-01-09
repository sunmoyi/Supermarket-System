package JavaBean;

public class Provider {
    private String providerPhone;
    private String providerLocation;
    private String providerName;
    private String providerId;

    public String getProviderId() {
        return providerId;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderLocation() {
        return providerLocation;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setProviderLocation(String providerLocation) {
        this.providerLocation = providerLocation;
    }
}
