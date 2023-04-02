/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern.creationalPattern.prototype;

/**
 *
 * @author Admin
 */
public class PrototypeUsingCloneableInterface   implements Cloneable {
    private String os;
    private String office;
    private String antivirus;
    private String browser;
    private String others;
 
 
    public PrototypeUsingCloneableInterface (String os, String office, String antivirus, String browser, String other) {
        super();
        this.os = os;
        this.office = office;
        this.antivirus = antivirus;
        this.browser = browser;
        this.others = other;
    }
 
    @Override
    protected PrototypeUsingCloneableInterface clone() {
        try {
            return (PrototypeUsingCloneableInterface) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public String toString() {
        return "Computer [os=" + os + ", office=" + office + ", antivirus=" + antivirus + ", browser=" + browser
                + ", others=" + others + "]";
    }
 
    public void setOthers(String others) {
        this.others = others;
    }
 public static void main(String[] args) {
        PrototypeUsingCloneableInterface computer1 = new PrototypeUsingCloneableInterface("Window 10", "Word 2013", "BKAV", "Chrome v69", "Skype");
        PrototypeUsingCloneableInterface computer2 = computer1.clone();
        computer2.setOthers("Skype, Teamviewer, FileZilla Client");
 
        System.out.println(computer1);
        System.out.println(computer2);
    }
}
