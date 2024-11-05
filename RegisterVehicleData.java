/* Storing ng datas for Registration ng vehicle. 
Pwede pa iimprove to since may next part pa ng registration.
 */

public class RegisterVehicleData {
    private String vehicleOwner;
    private String address;
    private String contactInformation;
    private String identificationNumber;
    private String dateOfBirth;

    public RegisterVehicleData(String vehicleOwner, String address, String contactInformation, String identificationNumber, String dateOfBirth) {
        this.vehicleOwner = vehicleOwner;
        this.address = address;
        this.identificationNumber = identificationNumber;
        this.contactInformation = contactInformation;
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getDateBirth() {
        return dateOfBirth;
    }

}
