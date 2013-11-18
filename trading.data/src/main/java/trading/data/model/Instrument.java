package trading.data.model;

import java.io.Serializable;

import javax.persistence.*;

import trading.data.Constants;

import java.util.List;


/**
 * The persistent class for the instrument database table.
 * 
 */
@Entity
@NamedQuery(name=Constants.QueryName.INSTRUMENT_FIND_ALL, query="SELECT i from Instrument i")
public class Instrument implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String code;
	private String shortCode;
	private String name;
	private List<Level1> level1s;

	public Instrument() {
	}


	@Id
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getShortCode() {
		return shortCode;
	}
	@Column(name="short_code")
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Level1
	@OneToMany(mappedBy="instrument")
	public List<Level1> getLevel1s() {
		return this.level1s;
	}

	public void setLevel1s(List<Level1> level1s) {
		this.level1s = level1s;
	}

	public Level1 addLevel1(Level1 level1) {
		getLevel1s().add(level1);
		level1.setInstrument(this);

		return level1;
	}

	public Level1 removeLevel1(Level1 level1) {
		getLevel1s().remove(level1);
		level1.setInstrument(null);

		return level1;
	}
	@Override
	public String toString(){
		return getCode();
	}
	
}