package modeloVO;

/**
 *
 * @author yatwa
 */
public class SEMVO {

    private String assetSN, assetNM, requestDate, account, department;

    public SEMVO() {
    }

    public SEMVO(String assetSN, String assetNM, String requestDate, String account, String department) {
        this.assetSN = assetSN;
        this.assetNM = assetNM;
        this.requestDate = requestDate;
        this.account = account;
        this.department = department;
    }

    public String getAssetSN() {
        return assetSN;
    }

    public void setAssetSN(String assetSN) {
        this.assetSN = assetSN;
    }

    public String getAssetNM() {
        return assetNM;
    }

    public void setAssetNM(String assetNM) {
        this.assetNM = assetNM;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
