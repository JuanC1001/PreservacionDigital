/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;

import java.sql.Timestamp;

/**
 *
 * @author RUBEN
 */
public class Auditoria_I_U_D {
    private int pk_audit;
    private String TableName;
    private String Operation;
    private String OldValue;
    private String NewValue;
    private Timestamp UpdateDate;
    private String UserName;

    public Auditoria_I_U_D() {
    }

    public Auditoria_I_U_D(int pk_audit, String TableName, String Operation, String OldValue, String NewValue, Timestamp UpdateDate, String UserName) {
        this.pk_audit = pk_audit;
        this.TableName = TableName;
        this.Operation = Operation;
        this.OldValue = OldValue;
        this.NewValue = NewValue;
        this.UpdateDate = UpdateDate;
        this.UserName = UserName;
    }

    public int getPk_audit() {
        return pk_audit;
    }

    public void setPk_audit(int pk_audit) {
        this.pk_audit = pk_audit;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String TableName) {
        this.TableName = TableName;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String Operation) {
        this.Operation = Operation;
    }

    public String getOldValue() {
        return OldValue;
    }

    public void setOldValue(String OldValue) {
        this.OldValue = OldValue;
    }

    public String getNewValue() {
        return NewValue;
    }

    public void setNewValue(String NewValue) {
        this.NewValue = NewValue;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Timestamp UpdateDate) {
        this.UpdateDate = UpdateDate;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

}
