package AmbroseRen.kit.parseXml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="RtnDt")
public class ICcard implements Serializable {
	
	private static final long serialVersionUID = 1710543859244212916L;
	
	@XmlElement(name="RegId")
	private String RegId;	
	@XmlElement(name="CardId")
	private String CardId;	
	@XmlElement(name="UserName")
	private String UserName; 	
	@XmlElement(name="Address")
	private String Address;	 
	@XmlElement(name="LocationOfMeter")
	private String LocationOfMeter;	 	
	@XmlElement(name="Price")
	private String Price;	
	@XmlElement(name="MaximumVolumeOfTheWaterBeSold")
	private Integer	MaximumVolumeOfTheWaterBeSold;	
	@XmlElement(name="MinimumVolumeOfTheWaterBeSold")
	private Integer	MinimumVolumeOfTheWaterBeSold;	
	@XmlElement(name="StatusOfSellingBeAuthorized")
	private Integer	StatusOfSellingBeAuthorized;
	@XmlElement(name="CauseOfTheWaterCannotBeSold")
	private String CauseOfTheWaterCannotBeSold;	
	@XmlElement(name="FilialeId")
	private String FilialeId;
	@XmlElement(name="Filiale")
	private String Filiale;	 
	@XmlElement(name="BusinessHall")
	private String BusinessHall;	 
	@XmlElement(name="AddressOfBusinessHall")
	private String AddressOfBusinessHall;
	@XmlElement(name="TelephoneNumberOfBusinessHall")
	private String TelephoneNumberOfBusinessHall;	 
	@XmlElement(name="Remark")
	private String Remark;
	
	@XmlTransient
	public String getRegId() {
		return RegId;
	}
	public void setRegId(String regId) {
		RegId = regId;
	}
	@XmlTransient
	public String getCardId() {
		return CardId;
	}
	public void setCardId(String cardId) {
		CardId = cardId;
	}
	@XmlTransient
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	@XmlTransient
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	@XmlTransient
	public String getLocationOfMeter() {
		return LocationOfMeter;
	}
	public void setLocationOfMeter(String locationOfMeter) {
		LocationOfMeter = locationOfMeter;
	}
	@XmlTransient
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	@XmlTransient
	public Integer getMaximumVolumeOfTheWaterBeSold() {
		return MaximumVolumeOfTheWaterBeSold;
	}
	public void setMaximumVolumeOfTheWaterBeSold(Integer maximumVolumeOfTheWaterBeSold) {
		MaximumVolumeOfTheWaterBeSold = maximumVolumeOfTheWaterBeSold;
	}
	@XmlTransient
	public Integer getMinimumVolumeOfTheWaterBeSold() {
		return MinimumVolumeOfTheWaterBeSold;
	}
	public void setMinimumVolumeOfTheWaterBeSold(Integer minimumVolumeOfTheWaterBeSold) {
		MinimumVolumeOfTheWaterBeSold = minimumVolumeOfTheWaterBeSold;
	}
	@XmlTransient
	public Integer getStatusOfSellingBeAuthorized() {
		return StatusOfSellingBeAuthorized;
	}
	public void setStatusOfSellingBeAuthorized(Integer statusOfSellingBeAuthorized) {
		StatusOfSellingBeAuthorized = statusOfSellingBeAuthorized;
	}
	@XmlTransient
	public String getCauseOfTheWaterCannotBeSold() {
		return CauseOfTheWaterCannotBeSold;
	}
	public void setCauseOfTheWaterCannotBeSold(String causeOfTheWaterCannotBeSold) {
		CauseOfTheWaterCannotBeSold = causeOfTheWaterCannotBeSold;
	}
	@XmlTransient
	public String getFilialeId() {
		return FilialeId;
	}
	public void setFilialeId(String filialeId) {
		FilialeId = filialeId;
	}
	@XmlTransient
	public String getFiliale() {
		return Filiale;
	}
	public void setFiliale(String filiale) {
		Filiale = filiale;
	}
	@XmlTransient
	public String getBusinessHall() {
		return BusinessHall;
	}
	public void setBusinessHall(String businessHall) {
		BusinessHall = businessHall;
	}
	@XmlTransient
	public String getAddressOfBusinessHall() {
		return AddressOfBusinessHall;
	}
	public void setAddressOfBusinessHall(String addressOfBusinessHall) {
		AddressOfBusinessHall = addressOfBusinessHall;
	}
	@XmlTransient
	public String getTelephoneNumberOfBusinessHall() {
		return TelephoneNumberOfBusinessHall;
	}
	public void setTelephoneNumberOfBusinessHall(String telephoneNumberOfBusinessHall) {
		TelephoneNumberOfBusinessHall = telephoneNumberOfBusinessHall;
	}
	@XmlTransient
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	@Override
	public String toString() {
		return "ICcard [RegId=" + RegId + ", CardId=" + CardId + ", UserName=" + UserName + ", Address=" + Address
				+ ", LocationOfMeter=" + LocationOfMeter + ", Price=" + Price + ", MaximumVolumeOfTheWaterBeSold="
				+ MaximumVolumeOfTheWaterBeSold + ", MinimumVolumeOfTheWaterBeSold=" + MinimumVolumeOfTheWaterBeSold
				+ ", StatusOfSellingBeAuthorized=" + StatusOfSellingBeAuthorized + ", CauseOfTheWaterCannotBeSold="
				+ CauseOfTheWaterCannotBeSold + ", FilialeId=" + FilialeId + ", Filiale=" + Filiale + ", BusinessHall="
				+ BusinessHall + ", AddressOfBusinessHall=" + AddressOfBusinessHall + ", TelephoneNumberOfBusinessHall="
				+ TelephoneNumberOfBusinessHall + ", Remark=" + Remark + "]";
	}		
	

}
