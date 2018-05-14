package com.example.alexi.mongo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class POJO {

    @SerializedName("_embedded")
    @Expose
    private List<Embedded> embedded = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("_returned")
    @Expose
    private Integer returned;

    public List<Embedded> getEmbedded() {
        return embedded;
    }

    public void setEmbedded(List<Embedded> embedded) {
        this.embedded = embedded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

}

class Embedded {

    @SerializedName("_id")
    @Expose
    private Id id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

class Id {

    @SerializedName("$oid")
    @Expose
    private String $oid;

    public String get$oid() {
        return $oid;
    }

    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

}
