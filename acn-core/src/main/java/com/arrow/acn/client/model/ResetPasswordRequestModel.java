package com.arrow.acn.client.model;

import java.io.Serializable;

public class ResetPasswordRequestModel implements Serializable {
    private static final long serialVersionUID = -4001682057856614908L;

    private boolean sendEmail;
    private String resetPasswordUrl;

    public ResetPasswordRequestModel withSendEmail(boolean sendEmail) {
        setSendEmail(sendEmail);
        return this;
    }

    public ResetPasswordRequestModel withResetPasswordUrl(String resetPasswordUrl) {
        setResetPasswordUrl(resetPasswordUrl);
        return this;
    }

    public boolean isSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getResetPasswordUrl() {
        return resetPasswordUrl;
    }

    public void setResetPasswordUrl(String resetPasswordUrl) {
        this.resetPasswordUrl = resetPasswordUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((resetPasswordUrl == null) ? 0 : resetPasswordUrl.hashCode());
        result = prime * result + (sendEmail ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResetPasswordRequestModel other = (ResetPasswordRequestModel) obj;
        if (resetPasswordUrl == null) {
            if (other.resetPasswordUrl != null)
                return false;
        } else if (!resetPasswordUrl.equals(other.resetPasswordUrl))
            return false;
        if (sendEmail != other.sendEmail)
            return false;
        return true;
    }
}
