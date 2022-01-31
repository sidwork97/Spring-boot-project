package com.hackathon.grievanceCell.payload.request;

import javax.validation.constraints.NotEmpty;

public class ComplaintRequest {

    @NotEmpty
    private String issueName;

    @NotEmpty
    private String description;

    private String imageUrl;

    public ComplaintRequest(@NotEmpty String issueName, @NotEmpty String description, String imageUrl) {
        this.issueName = issueName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
