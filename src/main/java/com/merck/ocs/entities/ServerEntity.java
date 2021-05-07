package com.merck.ocs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "servers")
public class ServerEntity extends AuditEntity {

	private static final long serialVersionUID = -9160321212042547408L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "server_name", nullable = false)
	private String name;

	@Column(name = "server_title", nullable = false)
	private String title;

	@Column(name = "server_os", nullable = false)
	private String os;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "component_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ComponentEntity component;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public ComponentEntity getComponent() {
		return component;
	}

	public void setComponent(ComponentEntity component) {
		this.component = component;
	}

}
