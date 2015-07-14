package com.autocasa.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author mramos
 */

/*id identity,
	title varchar(150),
	price varchar(15),
	comments varchar(2400),
	telContacto varchar(50),
	contacto varchar(50),
	infoVendedor varchar(550)
	*/
@Entity

@Table(name="PUBLICATIONS")
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String title;
    private String price;
    @Column(length=2400)
    private String comments;
    
    @Transient
    private Set<String> images;
    
    @Column(name="TELCONTACTO")
    private String telContacto;
    
    private String contacto; 
    
    @Column(name="INFOVENDEDOR", length=550)
    private String infoVendedor; 

    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public Publication() {
    }

    public String getTelContacto() {
        return telContacto;
    }

    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getInfoVendedor() {
        return infoVendedor;
    }

    public void setInfoVendedor(String infoVendedor) {
        this.infoVendedor = infoVendedor;
    }

    @Override
    public String toString() {
        return "Publication{" + "title=" + title + ", price=" + price + ", comments=" + comments + ", telContacto=" + telContacto + ", contacto=" + contacto + ", infoVendedor=" + infoVendedor + '}';
    }

    
}
