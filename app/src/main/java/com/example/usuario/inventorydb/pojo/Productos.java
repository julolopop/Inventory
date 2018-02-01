package com.example.usuario.inventorydb.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 1/02/18.
 */

public class Productos implements Parcelable {
    public static final String TAG = "Product";
    public static final Creator<Productos> CREATOR = new Creator<Productos>() {
        @Override
        public Productos createFromParcel(Parcel in) {
            return new Productos(in);
        }

        @Override
        public Productos[] newArray(int size) {
            return new Productos[size];
        }
    };
    int id;
    int dependencyId;
    String serial;
    String modelCode;
    String shortname;
    String description;
    int category;
    int productClass;
    int sectorID;
    int quantity;
    float value;
    String vendor;
    int bitmap;
    String imageName;
    String url;
    String datePurchase;
    String notes;

    public Productos(int id, int dependencyId, String serial, String modelCode, String shortname, String description, int category, int productClass, int sectorID, int quantity, float value, String vendor, int bitmap, String imageName, String url, String datePurchase, String notes) {
        this.id = id;
        this.dependencyId = dependencyId;
        this.serial = serial;
        this.modelCode = modelCode;
        this.shortname = shortname;
        this.description = description;
        this.category = category;
        this.productClass = productClass;
        this.sectorID = sectorID;
        this.quantity = quantity;
        this.value = value;
        this.vendor = vendor;
        this.bitmap = bitmap;
        this.imageName = imageName;
        this.url = url;
        this.datePurchase = datePurchase;
        this.notes = notes;
    }

    protected Productos(Parcel in) {
        id = in.readInt();
        dependencyId = in.readInt();
        serial = in.readString();
        modelCode = in.readString();
        shortname = in.readString();
        description = in.readString();
        category = in.readInt();
        productClass = in.readInt();
        sectorID = in.readInt();
        quantity = in.readInt();
        value = in.readFloat();
        vendor = in.readString();
        bitmap = in.readInt();
        imageName = in.readString();
        url = in.readString();
        datePurchase = in.readString();
        notes = in.readString();
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", dependencyId=" + dependencyId +
                ", serial='" + serial + '\'' +
                ", modelCode='" + modelCode + '\'' +
                ", shortname='" + shortname + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", productClass=" + productClass +
                ", sectorID=" + sectorID +
                ", quantity=" + quantity +
                ", value=" + value +
                ", vendor='" + vendor + '\'' +
                ", bitmap=" + bitmap +
                ", imageName='" + imageName + '\'' +
                ", url='" + url + '\'' +
                ", datePurchase='" + datePurchase + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public int get_ID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getProductClass() {
        return productClass;
    }

    public void setProductClass(int productClass) {
        this.productClass = productClass;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getBitmap() {
        return bitmap;
    }

    public void setBitmap(int bitmap) {
        this.bitmap = bitmap;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(dependencyId);
        parcel.writeString(serial);
        parcel.writeString(modelCode);
        parcel.writeString(shortname);
        parcel.writeString(description);
        parcel.writeInt(category);
        parcel.writeInt(productClass);
        parcel.writeInt(sectorID);
        parcel.writeInt(quantity);
        parcel.writeFloat(value);
        parcel.writeString(vendor);
        parcel.writeInt(bitmap);
        parcel.writeString(imageName);
        parcel.writeString(url);
        parcel.writeString(datePurchase);
        parcel.writeString(notes);
    }
}