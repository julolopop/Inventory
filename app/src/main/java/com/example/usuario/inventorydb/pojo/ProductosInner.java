package com.example.usuario.inventorydb.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductosInner implements Parcelable {
    public static final String TAG = "ProductosInner";

    int id;
    int dependencyId;
    String serial;
    String modelCode;
    String shortname;
    String description;
    String  category;
    String  productClass;
    String  sectorID;
    int quantity;
    float value;
    String vendor;
    int bitmap;
    String imageName;
    String url;
    String datePurchase;
    String notes;

    @Override
    public String toString() {
        return "ProductosInner{" +
                "id=" + id +
                ", dependencyId=" + dependencyId +
                ", serial='" + serial + '\'' +
                ", modelCode='" + modelCode + '\'' +
                ", shortname='" + shortname + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", productClass='" + productClass + '\'' +
                ", sectorID='" + sectorID + '\'' +
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

    public int getId() {
        return id;
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public String getSerial() {
        return serial;
    }

    public String getModelCode() {
        return modelCode;
    }

    public String getShortname() {
        return shortname;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getProductClass() {
        return productClass;
    }

    public String getSectorID() {
        return sectorID;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getValue() {
        return value;
    }

    public String getVendor() {
        return vendor;
    }

    public int getBitmap() {
        return bitmap;
    }

    public String getImageName() {
        return imageName;
    }

    public String getUrl() {
        return url;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public String getNotes() {
        return notes;
    }

    public ProductosInner(int id, int dependencyId, String serial, String modelCode, String shortname, String description, String category, String productClass, String sectorID, int quantity, float value, String vendor, int bitmap, String imageName, String url, String datePurchase, String notes) {
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

    protected ProductosInner(Parcel in) {
        id = in.readInt();
        dependencyId = in.readInt();
        serial = in.readString();
        modelCode = in.readString();
        shortname = in.readString();
        description = in.readString();
        category = in.readString();
        productClass = in.readString();
        sectorID = in.readString();
        quantity = in.readInt();
        value = in.readFloat();
        vendor = in.readString();
        bitmap = in.readInt();
        imageName = in.readString();
        url = in.readString();
        datePurchase = in.readString();
        notes = in.readString();
    }

    public static final Creator<ProductosInner> CREATOR = new Creator<ProductosInner>() {
        @Override
        public ProductosInner createFromParcel(Parcel in) {
            return new ProductosInner(in);
        }

        @Override
        public ProductosInner[] newArray(int size) {
            return new ProductosInner[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(dependencyId);
        dest.writeString(serial);
        dest.writeString(modelCode);
        dest.writeString(shortname);
        dest.writeString(description);
        dest.writeString(category);
        dest.writeString(productClass);
        dest.writeString(sectorID);
        dest.writeInt(quantity);
        dest.writeFloat(value);
        dest.writeString(vendor);
        dest.writeInt(bitmap);
        dest.writeString(imageName);
        dest.writeString(url);
        dest.writeString(datePurchase);
        dest.writeString(notes);
    }
}