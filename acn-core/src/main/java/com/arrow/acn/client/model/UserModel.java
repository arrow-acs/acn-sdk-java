package com.arrow.acn.client.model;

public class UserModel extends BaseUserModel {
    private static final long serialVersionUID = 1116738116612532820L;

    private String login;
    private String hid;
    private String pri;

    public UserModel withLogin(String login) {
        setLogin(login);
        return this;
    }

    public UserModel withHid(String hid) {
        setHid(hid);
        return this;
    }

    public UserModel withPri(String pri) {
        setPri(pri);
        return this;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((hid == null) ? 0 : hid.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((pri == null) ? 0 : pri.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserModel other = (UserModel) obj;
        if (hid == null) {
            if (other.hid != null)
                return false;
        } else if (!hid.equals(other.hid))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (pri == null) {
            if (other.pri != null)
                return false;
        } else if (!pri.equals(other.pri))
            return false;
        return true;
    }
}
