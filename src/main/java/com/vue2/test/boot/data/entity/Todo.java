
package com.vue2.test.boot.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TODO")
public class Todo implements Serializable {

	private static final long serialVersionUID = 8592866989186068519L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id = 0L;

	@Column(name="TITLE")
	private String title = null;

	@Column(name="COMPLETED")
	private boolean completed = false;

	public Todo() {

	}

	public Todo(long id, String title, boolean completed) {
		this.id = id;
		this.title = title;
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo{id=" + id + ",title=" + title + ",completed=" + completed + "}";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}