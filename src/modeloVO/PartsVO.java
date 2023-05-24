/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloVO;

/**
 *
 * @author SUBDIRECCIÓN SENA
 */
public class PartsVO {
    private String ID, Name, EffectiveLive;

    public PartsVO(String ID, String Name, String EffectiveLive) {
        this.ID = ID;
        this.Name = Name;
        this.EffectiveLive = EffectiveLive;
    }

    public PartsVO() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEffectiveLive() {
        return EffectiveLive;
    }

    public void setEffectiveLive(String EffectiveLive) {
        this.EffectiveLive = EffectiveLive;
    }
    
    
}
