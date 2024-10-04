package com.project.bankingapplication.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "BillerProvider")
public class BillerProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" , nullable = true)
	private long id;

	@Column(name = "ConsumerNumberFk")
	private long consumerNumberFk;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getConsumerNumberFk() {
		return consumerNumberFk;
	}

	public void setConsumerNumberFk(long consumerNumberFk) {
		this.consumerNumberFk = consumerNumberFk;
	}

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getTansId() {
		return tansId;
	}

	public void setTansId(long tansId) {
		this.tansId = tansId;
	}

	public static LocalDate getLocalDate() {
		return localDate;
	}

	public static void setLocalDate(LocalDate localDate) {
		BillerProvider.localDate = localDate;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Column(name = "Acc_Number")
	private long accNumber;

	@Column(name= "Amount")
	private int amount;
	
	@Column(name = "Trans_Id")
	private long tansId;
	
	static LocalDate localDate;
	public static LocalDate getTimeStamp() {
		localDate = localDate.now();
		return localDate;
	}
	
	@Column(name = "TimeStamp")
	private LocalDate timeStamp;
	
//	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name="biller_register_id")
//	private BillerRegister billerRegister;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "biller_register_id_fk", referencedColumnName = "id")
//    private BillerRegister billerRegister;

}
