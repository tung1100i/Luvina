/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.observer2;

class User {
    private String email;
    private String ip;
    private LoginStatus status;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the status
     */
    public LoginStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(LoginStatus status) {
        this.status = status;
    }
}
 