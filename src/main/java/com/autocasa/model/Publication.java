/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autocasa.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

/**
 *
 * @author mramos
 */
@Entity(name="publications")
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="OGIMAGE")
    private String ogImage;
	@Column(name="OGDESCRIPTION", length=2024)
    private String ogDescription;
	@Column(name="OGTITLE")
    private String ogTitle;
	@Column(name="CONTACTOWNER")
    private String contactOwner;
	@Column(name="CONTACTOWNERPHONE")
    private String contactOwnerPhone;
	@Column(name="CONTACTPRICE")
    private String contactPrice;
	@Column(name="CONTACTBRAND")
    private String contactBrand;
	@Column(name="CONTACTMODEL")
    private String contactModel;
	@Column(name="CONTACTYEAR")
    private String contactYear;
	@Column(name="GENERALINFOTABLE", length=5200)
    private String generalInfoTable;
	@Column(length=5200)
    private String images;
    @Column(name="PAGETITLEEXTENDED")
    private String pageTitleExtended;
    @Column(name="DESCCONTACTAPH")
    private String descContactAPh;
    @Column(name="DESCCONTACTB")
    private String descContactB;
    private String price;
    private String kilometers;
    @Column(length=2400)
    private String comments;
    @Column(name="SELLERINFO", length=3048)
    private String sellerInfo;
    @Column(name="CONTACTOWNERSECONDPHONE")
    private String contactOwnerSecondPhone;

    @Override
    public String toString() {
        String queryTemplate = 
                "insert into publications (ogImage, ogDescription, ogTitle, contactOwner, contactOwnerPhone, contactPrice, contactBrand, contactModel, "
                + "contactYear,  generalInfoTable, images, pageTitleExtended, descContactAPh, descContactB, price, kilometers, comments, sellerInfo, contactOwnerSecondPhone) "+
                "values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'); ";
       
        return String.format(queryTemplate,
                ogImage, ogDescription, ogTitle, contactOwner, contactOwnerPhone, contactPrice, contactBrand, contactModel,
                contactYear, generalInfoTable, getImages(), pageTitleExtended, descContactAPh, descContactB, price, 
                kilometers, comments, sellerInfo, contactOwnerSecondPhone).replace("\n", " ").replace("\r\n", " ").replace("\t", " ").replaceAll("\\s", " ");
    }

    public void setId(Long id) {
    	this.id = id;
    }
    
    public Long getId() {
    	return id;
    }
    public String getOgImage() {
        return ogImage;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public String getOgDescription() {
        return ogDescription;
    }

    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    public String getOgTitle() {
        return ogTitle;
    }

    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public String getContactOwner() {
        return contactOwner;
    }

    public void setContactOwner(String contactOwner) {
        this.contactOwner = contactOwner;
    }

    public String getContactOwnerPhone() {
        return contactOwnerPhone;
    }

    public void setContactOwnerPhone(String contactOwnerPhone) {
        this.contactOwnerPhone = contactOwnerPhone;
    }

    public String getContactPrice() {
        return contactPrice;
    }

    public void setContactPrice(String contactPrice) {
        this.contactPrice = contactPrice;
    }

    public String getContactBrand() {
        return contactBrand;
    }

    public void setContactBrand(String contactBrand) {
        this.contactBrand = contactBrand;
    }

    public String getContactModel() {
        return contactModel;
    }

    public void setContactModel(String contactModel) {
        this.contactModel = contactModel;
    }

    public String getContactYear() {
        return contactYear;
    }

    public void setContactYear(String contactYear) {
        this.contactYear = contactYear;
    }

    public List<String> getGeneralInfoTable() {
    	List<String> featuresList = new ArrayList<>();
    	Document doc = Jsoup.parse(generalInfoTable,"/", Parser.xmlParser());
    	for (Element tr : doc.getElementsByTag("tr")) {
    		String concatTds = "";
    		for (Element td: tr.children()) {
				concatTds += td.text()+"|";
			}
    		featuresList.add(concatTds);
		}
        return featuresList;
    }

    public void setGeneralInfoTable(String generalInfoTable) {
        this.generalInfoTable = generalInfoTable;
    }

    public List<String> getImages() {
        return Arrays.asList(images.split("\\|"));
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPageTitleExtended() {
        return pageTitleExtended;
    }

    public void setPageTitleExtended(String pageTitleExtended) {
        this.pageTitleExtended = pageTitleExtended;
    }

    public String getDescContactAPh() {
        return descContactAPh;
    }

    public void setDescContactAPh(String descContactAPh) {
        this.descContactAPh = descContactAPh;
    }

    public String getDescContactB() {
        return descContactB;
    }

    public void setDescContactB(String descContactB) {
        this.descContactB = descContactB;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(String sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public String getContactOwnerSecondPhone() {
        return contactOwnerSecondPhone;
    }

    public void setContactOwnerSecondPhone(String contactOwnerSecondPhone) {
        this.contactOwnerSecondPhone = contactOwnerSecondPhone;
    }
    
}
