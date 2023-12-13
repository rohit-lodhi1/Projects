package com.roverse.com.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_tbl")
public class Product {
	@Id
	@Column(name="p_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pId;
	@Column(name="p_code")
    private String pCode; 
	
	@ElementCollection
	@CollectionTable(name="product_colors",joinColumns = @JoinColumn(name="p_idfk"))
	@OrderColumn(name="pos" )
    @Column(name="data")
    private List<String> colors;
	

	@ElementCollection
	@CollectionTable(name="product_models",joinColumns = @JoinColumn(name="p_idfk"))
	@Column(name="model")
    private Set<String> models;
    

	@ElementCollection
	@CollectionTable(name="product_details",joinColumns = @JoinColumn(name="p_idfk"))
	@MapKeyColumn(name="code")
	@Column(name="details")
    private Map<String, String> details ;
    
}
 