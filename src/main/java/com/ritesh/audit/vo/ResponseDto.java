package com.ritesh.audit.vo;

public class ResponseDto {
    Object preDetails;
    Object postDetails;

    public ResponseDto(Object preDetails, Object postDetails) {
        this.preDetails = preDetails;
        this.postDetails = postDetails;
    }

    public Object getPreDetails() {
        return preDetails;
    }

    public void setPreDetails(Object preDetails) {
        this.preDetails = preDetails;
    }

    public Object getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(Object postDetails) {
        this.postDetails = postDetails;
    }
}
