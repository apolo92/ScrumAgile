package com.scrum.agile.security;

import com.auth0.jwt.JWTSigner;

import java.util.HashMap;

/**
 * Created by apolo & agustibm on 11/08/2016.
 */
public class Token {

    private String password;
    private final HashMap<String, Object> info;
    private final HashMap<String, Object> token;
    private long expires;
    private long initTokenDate;

    private JWTSigner tokenSigner;
    private String infoToken;


    public Token(String password) {
        this.token = new HashMap<String, Object>();
        this.info = new HashMap<String, Object>();
        this.password = password;
        this.tokenSigner = new JWTSigner(password);
        this.infoToken = "";
    }

    public String sign(){
        this.token.put("iss", this.infoToken);
        this.token.put("initTokenDate", this.initTokenDate);
        this.token.put("exp", this.expires);
        return tokenSigner.sign(this.token);
    }

    public void setExpires(long expires) {
        this.initTokenDate = System.currentTimeMillis() / 1000L;
        this.expires = initTokenDate + expires;
    }

    public void addInfo(String info) {
        //TODO: Change String to JSON OBject
        this.infoToken += info;
    }
}
