package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;
	private String tipo;
//	private String urlFoto;
//	private String urlVideo;
//	private String latitude;
//	private String longitude;

	
	public Carro() {

	}
	
	public Carro(Long id, String nome, String tipo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

//	public String getUrlFoto() {
//		return urlFoto;
//	}
//
//	public void setUrlFoto(String urlFoto) {
//		this.urlFoto = urlFoto;
//	}
//
//	public String getUrlVideo() {
//		return urlVideo;
//	}
//
//	public void setUrlVideo(String urlVideo) {
//		this.urlVideo = urlVideo;
//	}
//
//	public String getLatitude() {
//		return latitude;
//	}
//
//	public void setLatitude(String latitude) {
//		this.latitude = latitude;
//	}
//
//	public String getLongitude() {
//		return longitude;
//	}
//
//	public void setLongitude(String longitude) {
//		this.longitude = longitude;
//	}
//		
}
