package domain;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import lombok.Data;

//objeto resumido de uma tabela por exemplo com 10 colunas e monta o json com 8
public class CarroDTO {

		private Long id;		
		private String nome;
		private String tipo;
//		private String urlFoto;
//		private String urlVideo;
//		private String latitude;
//		private String longitude;
		
		public CarroDTO() {

		}
		
		public CarroDTO(Carro c) {
		this.id = c.getId();
		this.nome = c.getNome();
		this.tipo = c.getTipo();
		}
		
	    public static CarroDTO create(Carro carro) {
	        ModelMapper modelMapper = new ModelMapper();
	        return modelMapper.map(carro, CarroDTO.class);
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


//		public String getUrlFoto() {
//			return urlFoto;
//		}
//
//		public void setUrlFoto(String urlFoto) {
//			this.urlFoto = urlFoto;
//		}
//
//		public String getUrlVideo() {
//			return urlVideo;
//		}
//
//		public void setUrlVideo(String urlVideo) {
//			this.urlVideo = urlVideo;
//		}
//
//		public String getLatitude() {
//			return latitude;
//		}
//
//		public void setLatitude(String latitude) {
//			this.latitude = latitude;
//		}
//
//		public String getLongitude() {
//			return longitude;
//		}
//
//		public void setLongitude(String longitude) {
//			this.longitude = longitude;
//		}	
	}

