package com.example.dto.request;

public class TokenDtoRequest {
    private String token;

    public TokenDtoRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenDtoRequest that)) return false;

        return getToken() != null ? getToken().equals(that.getToken()) : that.getToken() == null;
    }

    @Override
    public int hashCode() {
        return getToken() != null ? getToken().hashCode() : 0;
    }
}
