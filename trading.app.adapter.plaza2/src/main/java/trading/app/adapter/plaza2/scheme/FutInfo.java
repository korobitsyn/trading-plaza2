package trading.app.adapter.plaza2.scheme;

public final class FutInfo
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class delivery_report
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 180;
        private java.nio.ByteBuffer data;

        public delivery_report() {
            
        }

        public delivery_report(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public java.util.Date get_date() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date(java.util.Date val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public String get_client_code() {
            data.position(34);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(34);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_type() {
            data.position(42);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 2);
        }

        public void set_type(String val) {
            data.position(42);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 2);
        }

        
    
        public int get_isin_id() {
            data.position(48);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public int get_pos() {
            data.position(52);
            return data.getInt();
        }

        public void set_pos(int val) {
            data.position(52);
            data.putInt(val);
        }

        
    
        public int get_pos_excl() {
            data.position(56);
            return data.getInt();
        }

        public void set_pos_excl(int val) {
            data.position(56);
            data.putInt(val);
        }

        
    
        public int get_pos_unexec() {
            data.position(60);
            return data.getInt();
        }

        public void set_pos_unexec(int val) {
            data.position(60);
            data.putInt(val);
        }

        
    
        public byte get_unexec() {
            data.position(64);
            return data.get();
        }

        public void set_unexec(byte val) {
            data.position(64);
            data.put(val);
        }

        
    
        public String get_settl_pair() {
            data.position(65);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 12);
        }

        public void set_settl_pair(String val) {
            data.position(65);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 12);
        }

        
    
        public String get_asset_code() {
            data.position(78);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_asset_code(String val) {
            data.position(78);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_issue_code() {
            data.position(104);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_issue_code(String val) {
            data.position(104);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public java.math.BigDecimal get_oblig_rur() {
            data.position(130);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_oblig_rur(java.math.BigDecimal val) {
            data.position(130);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_oblig_rur_scale() {
            data.position(130);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public long get_oblig_qty() {
            data.position(140);
            return data.getLong();
        }

        public void set_oblig_qty(long val) {
            data.position(140);
            data.putLong(val);
        }

        
    
        public java.math.BigDecimal get_fulfil_rur() {
            data.position(148);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fulfil_rur(java.math.BigDecimal val) {
            data.position(148);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fulfil_rur_scale() {
            data.position(148);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public long get_fulfil_qty() {
            data.position(160);
            return data.getLong();
        }

        public void set_fulfil_qty(long val) {
            data.position(160);
            data.putLong(val);
        }

        
    
        public int get_step() {
            data.position(168);
            return data.getInt();
        }

        public void set_step(int val) {
            data.position(168);
            data.putInt(val);
        }

        
    
        public int get_sess_id() {
            data.position(172);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(172);
            data.putInt(val);
        }

        
    
        public int get_id_gen() {
            data.position(176);
            return data.getInt();
        }

        public void set_id_gen(int val) {
            data.position(176);
            data.putInt(val);
        }

        
    


    }

    public static final class fut_rejected_orders
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 416;
        private java.nio.ByteBuffer data;

        public fut_rejected_orders() {
            
        }

        public fut_rejected_orders(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public long get_order_id() {
            data.position(24);
            return data.getLong();
        }

        public void set_order_id(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(32);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(32);
            data.putInt(val);
        }

        
    
        public String get_client_code() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(36);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.util.Date get_moment() {
            data.position(44);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(44);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_moment_reject() {
            data.position(54);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment_reject(java.util.Date val) {
            data.position(54);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_isin_id() {
            data.position(64);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(64);
            data.putInt(val);
        }

        
    
        public byte get_dir() {
            data.position(68);
            return data.get();
        }

        public void set_dir(byte val) {
            data.position(68);
            data.put(val);
        }

        
    
        public int get_amount() {
            data.position(72);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_price() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(76);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_date_exp() {
            data.position(88);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date_exp(java.util.Date val) {
            data.position(88);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public long get_id_ord1() {
            data.position(100);
            return data.getLong();
        }

        public void set_id_ord1(long val) {
            data.position(100);
            data.putLong(val);
        }

        
    
        public int get_ret_code() {
            data.position(108);
            return data.getInt();
        }

        public void set_ret_code(int val) {
            data.position(108);
            data.putInt(val);
        }

        
    
        public String get_ret_message() {
            data.position(112);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_ret_message(String val) {
            data.position(112);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public String get_comment() {
            data.position(368);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment(String val) {
            data.position(368);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_login_from() {
            data.position(389);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_login_from(String val) {
            data.position(389);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public int get_ext_id() {
            data.position(412);
            return data.getInt();
        }

        public void set_ext_id(int val) {
            data.position(412);
            data.putInt(val);
        }

        
    


    }

    public static final class fut_intercl_info
    {
        public static final int TABLE_INDEX = 2;
        
	public static final int MSG_SIZE = 46;
        private java.nio.ByteBuffer data;

        public fut_intercl_info() {
            
        }

        public fut_intercl_info(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_isin_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public String get_client_code() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.math.BigDecimal get_vm_intercl() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm_intercl(java.math.BigDecimal val) {
            data.position(36);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vm_intercl_scale() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class fut_bond_registry
    {
        public static final int TABLE_INDEX = 3;
        
	public static final int MSG_SIZE = 180;
        private java.nio.ByteBuffer data;

        public fut_bond_registry() {
            
        }

        public fut_bond_registry(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_bond_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_bond_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public String get_small_name() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_small_name(String val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_short_isin() {
            data.position(54);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_short_isin(String val) {
            data.position(54);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_name() {
            data.position(80);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 75);
        }

        public void set_name(String val) {
            data.position(80);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 75);
        }

        
    
        public java.util.Date get_date_redempt() {
            data.position(156);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date_redempt(java.util.Date val) {
            data.position(156);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.math.BigDecimal get_nominal() {
            data.position(166);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_nominal(java.math.BigDecimal val) {
            data.position(166);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_nominal_scale() {
            data.position(166);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_bond_type() {
            data.position(177);
            return data.get();
        }

        public void set_bond_type(byte val) {
            data.position(177);
            data.put(val);
        }

        
    
        public short get_year_base() {
            data.position(178);
            return data.getShort();
        }

        public void set_year_base(short val) {
            data.position(178);
            data.putShort(val);
        }

        
    


    }

    public static final class fut_bond_isin
    {
        public static final int TABLE_INDEX = 4;
        
	public static final int MSG_SIZE = 37;
        private java.nio.ByteBuffer data;

        public fut_bond_isin() {
            
        }

        public fut_bond_isin(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_isin_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public int get_bond_id() {
            data.position(28);
            return data.getInt();
        }

        public void set_bond_id(int val) {
            data.position(28);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_coeff_conversion() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_coeff_conversion(java.math.BigDecimal val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d5.4", val);
        }

        
        public byte get_coeff_conversion_scale() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class fut_bond_nkd
    {
        public static final int TABLE_INDEX = 5;
        
	public static final int MSG_SIZE = 49;
        private java.nio.ByteBuffer data;

        public fut_bond_nkd() {
            
        }

        public fut_bond_nkd(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_bond_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_bond_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public java.util.Date get_date() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date(java.util.Date val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.math.BigDecimal get_nkd() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_nkd(java.math.BigDecimal val) {
            data.position(38);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.7", val);
        }

        
        public byte get_nkd_scale() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class fut_bond_nominal
    {
        public static final int TABLE_INDEX = 6;
        
	public static final int MSG_SIZE = 49;
        private java.nio.ByteBuffer data;

        public fut_bond_nominal() {
            
        }

        public fut_bond_nominal(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_bond_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_bond_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public java.util.Date get_date() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date(java.util.Date val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.math.BigDecimal get_nominal() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_nominal(java.math.BigDecimal val) {
            data.position(38);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_nominal_scale() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class fut_vcb
    {
        public static final int TABLE_INDEX = 7;
        
	public static final int MSG_SIZE = 256;
        private java.nio.ByteBuffer data;

        public fut_vcb() {
            
        }

        public fut_vcb(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_code_vcb() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_name() {
            data.position(50);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 75);
        }

        public void set_name(String val) {
            data.position(50);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 75);
        }

        
    
        public String get_exec_type() {
            data.position(126);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 1);
        }

        public void set_exec_type(String val) {
            data.position(126);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 1);
        }

        
    
        public String get_curr() {
            data.position(128);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_curr(String val) {
            data.position(128);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public java.math.BigDecimal get_exch_pay() {
            data.position(132);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_exch_pay(java.math.BigDecimal val) {
            data.position(132);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_exch_pay_scale() {
            data.position(132);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_exch_pay_scalped() {
            data.position(142);
            return data.get();
        }

        public void set_exch_pay_scalped(byte val) {
            data.position(142);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_clear_pay() {
            data.position(143);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_clear_pay(java.math.BigDecimal val) {
            data.position(143);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_clear_pay_scale() {
            data.position(143);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_clear_pay_scalped() {
            data.position(153);
            return data.get();
        }

        public void set_clear_pay_scalped(byte val) {
            data.position(153);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_sell_fee() {
            data.position(154);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_sell_fee(java.math.BigDecimal val) {
            data.position(154);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d7.3", val);
        }

        
        public byte get_sell_fee_scale() {
            data.position(154);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_buy_fee() {
            data.position(160);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_buy_fee(java.math.BigDecimal val) {
            data.position(160);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d7.3", val);
        }

        
        public byte get_buy_fee_scale() {
            data.position(160);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public String get_trade_scheme() {
            data.position(166);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 1);
        }

        public void set_trade_scheme(String val) {
            data.position(166);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 1);
        }

        
    
        public String get_section() {
            data.position(168);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 50);
        }

        public void set_section(String val) {
            data.position(168);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 50);
        }

        
    
        public java.math.BigDecimal get_exch_pay_spot() {
            data.position(219);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_exch_pay_spot(java.math.BigDecimal val) {
            data.position(219);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_exch_pay_spot_scale() {
            data.position(219);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public String get_client_code() {
            data.position(230);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(230);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.math.BigDecimal get_exch_pay_spot_repo() {
            data.position(238);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_exch_pay_spot_repo(java.math.BigDecimal val) {
            data.position(238);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_exch_pay_spot_repo_scale() {
            data.position(238);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_rate_id() {
            data.position(252);
            return data.getInt();
        }

        public void set_rate_id(int val) {
            data.position(252);
            data.putInt(val);
        }

        
    


    }

    public static final class session
    {
        public static final int TABLE_INDEX = 8;
        
	public static final int MSG_SIZE = 144;
        private java.nio.ByteBuffer data;

        public session() {
            
        }

        public session(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public java.util.Date get_begin() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_begin(java.util.Date val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_end() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_end(java.util.Date val) {
            data.position(38);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_state() {
            data.position(48);
            return data.getInt();
        }

        public void set_state(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public int get_opt_sess_id() {
            data.position(52);
            return data.getInt();
        }

        public void set_opt_sess_id(int val) {
            data.position(52);
            data.putInt(val);
        }

        
    
        public java.util.Date get_inter_cl_begin() {
            data.position(56);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_inter_cl_begin(java.util.Date val) {
            data.position(56);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_inter_cl_end() {
            data.position(66);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_inter_cl_end(java.util.Date val) {
            data.position(66);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_inter_cl_state() {
            data.position(76);
            return data.getInt();
        }

        public void set_inter_cl_state(int val) {
            data.position(76);
            data.putInt(val);
        }

        
    
        public byte get_eve_on() {
            data.position(80);
            return data.get();
        }

        public void set_eve_on(byte val) {
            data.position(80);
            data.put(val);
        }

        
    
        public java.util.Date get_eve_begin() {
            data.position(82);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_eve_begin(java.util.Date val) {
            data.position(82);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_eve_end() {
            data.position(92);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_eve_end(java.util.Date val) {
            data.position(92);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_mon_on() {
            data.position(102);
            return data.get();
        }

        public void set_mon_on(byte val) {
            data.position(102);
            data.put(val);
        }

        
    
        public java.util.Date get_mon_begin() {
            data.position(104);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_mon_begin(java.util.Date val) {
            data.position(104);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_mon_end() {
            data.position(114);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_mon_end(java.util.Date val) {
            data.position(114);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_pos_transfer_begin() {
            data.position(124);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_pos_transfer_begin(java.util.Date val) {
            data.position(124);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_pos_transfer_end() {
            data.position(134);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_pos_transfer_end(java.util.Date val) {
            data.position(134);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class multileg_dict
    {
        public static final int TABLE_INDEX = 9;
        
	public static final int MSG_SIZE = 40;
        private java.nio.ByteBuffer data;

        public multileg_dict() {
            
        }

        public multileg_dict(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public int get_isin_id() {
            data.position(28);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(28);
            data.putInt(val);
        }

        
    
        public int get_isin_id_leg() {
            data.position(32);
            return data.getInt();
        }

        public void set_isin_id_leg(int val) {
            data.position(32);
            data.putInt(val);
        }

        
    
        public int get_qty_ratio() {
            data.position(36);
            return data.getInt();
        }

        public void set_qty_ratio(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    


    }

    public static final class fut_sess_contents
    {
        public static final int TABLE_INDEX = 10;
        
	public static final int MSG_SIZE = 407;
        private java.nio.ByteBuffer data;

        public fut_sess_contents() {
            
        }

        public fut_sess_contents(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public int get_isin_id() {
            data.position(28);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(28);
            data.putInt(val);
        }

        
    
        public String get_short_isin() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_short_isin(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_isin() {
            data.position(58);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(58);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_name() {
            data.position(84);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 75);
        }

        public void set_name(String val) {
            data.position(84);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 75);
        }

        
    
        public int get_inst_term() {
            data.position(160);
            return data.getInt();
        }

        public void set_inst_term(int val) {
            data.position(160);
            data.putInt(val);
        }

        
    
        public String get_code_vcb() {
            data.position(164);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(164);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public byte get_is_limited() {
            data.position(190);
            return data.get();
        }

        public void set_is_limited(byte val) {
            data.position(190);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_limit_up() {
            data.position(191);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_limit_up(java.math.BigDecimal val) {
            data.position(191);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_limit_up_scale() {
            data.position(191);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_limit_down() {
            data.position(202);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_limit_down(java.math.BigDecimal val) {
            data.position(202);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_limit_down_scale() {
            data.position(202);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_old_kotir() {
            data.position(213);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_old_kotir(java.math.BigDecimal val) {
            data.position(213);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_old_kotir_scale() {
            data.position(213);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_buy_deposit() {
            data.position(224);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_buy_deposit(java.math.BigDecimal val) {
            data.position(224);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_buy_deposit_scale() {
            data.position(224);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_sell_deposit() {
            data.position(234);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_sell_deposit(java.math.BigDecimal val) {
            data.position(234);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_sell_deposit_scale() {
            data.position(234);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_roundto() {
            data.position(244);
            return data.getInt();
        }

        public void set_roundto(int val) {
            data.position(244);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_min_step() {
            data.position(248);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_min_step(java.math.BigDecimal val) {
            data.position(248);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_min_step_scale() {
            data.position(248);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_lot_volume() {
            data.position(260);
            return data.getInt();
        }

        public void set_lot_volume(int val) {
            data.position(260);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_step_price() {
            data.position(264);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price(java.math.BigDecimal val) {
            data.position(264);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_scale() {
            data.position(264);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_d_pg() {
            data.position(276);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_pg(java.util.Date val) {
            data.position(276);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_is_spread() {
            data.position(286);
            return data.get();
        }

        public void set_is_spread(byte val) {
            data.position(286);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_coeff() {
            data.position(287);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_coeff(java.math.BigDecimal val) {
            data.position(287);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d9.6", val);
        }

        
        public byte get_coeff_scale() {
            data.position(287);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_d_exp() {
            data.position(294);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_exp(java.util.Date val) {
            data.position(294);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_is_percent() {
            data.position(304);
            return data.get();
        }

        public void set_is_percent(byte val) {
            data.position(304);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_percent_rate() {
            data.position(305);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_percent_rate(java.math.BigDecimal val) {
            data.position(305);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d6.2", val);
        }

        
        public byte get_percent_rate_scale() {
            data.position(305);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_last_cl_quote() {
            data.position(310);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_last_cl_quote(java.math.BigDecimal val) {
            data.position(310);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_last_cl_quote_scale() {
            data.position(310);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_signs() {
            data.position(324);
            return data.getInt();
        }

        public void set_signs(int val) {
            data.position(324);
            data.putInt(val);
        }

        
    
        public byte get_is_trade_evening() {
            data.position(328);
            return data.get();
        }

        public void set_is_trade_evening(byte val) {
            data.position(328);
            data.put(val);
        }

        
    
        public int get_ticker() {
            data.position(332);
            return data.getInt();
        }

        public void set_ticker(int val) {
            data.position(332);
            data.putInt(val);
        }

        
    
        public int get_state() {
            data.position(336);
            return data.getInt();
        }

        public void set_state(int val) {
            data.position(336);
            data.putInt(val);
        }

        
    
        public byte get_price_dir() {
            data.position(340);
            return data.get();
        }

        public void set_price_dir(byte val) {
            data.position(340);
            data.put(val);
        }

        
    
        public int get_multileg_type() {
            data.position(344);
            return data.getInt();
        }

        public void set_multileg_type(int val) {
            data.position(344);
            data.putInt(val);
        }

        
    
        public int get_legs_qty() {
            data.position(348);
            return data.getInt();
        }

        public void set_legs_qty(int val) {
            data.position(348);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_step_price_clr() {
            data.position(352);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price_clr(java.math.BigDecimal val) {
            data.position(352);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_clr_scale() {
            data.position(352);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_step_price_interclr() {
            data.position(363);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price_interclr(java.math.BigDecimal val) {
            data.position(363);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_interclr_scale() {
            data.position(363);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_step_price_curr() {
            data.position(374);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price_curr(java.math.BigDecimal val) {
            data.position(374);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_curr_scale() {
            data.position(374);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_d_start() {
            data.position(386);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_start(java.util.Date val) {
            data.position(386);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.math.BigDecimal get_exch_pay() {
            data.position(396);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_exch_pay(java.math.BigDecimal val) {
            data.position(396);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_exch_pay_scale() {
            data.position(396);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class fut_instruments
    {
        public static final int TABLE_INDEX = 11;
        
	public static final int MSG_SIZE = 364;
        private java.nio.ByteBuffer data;

        public fut_instruments() {
            
        }

        public fut_instruments(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_isin_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public String get_short_isin() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_short_isin(String val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_isin() {
            data.position(54);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(54);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_name() {
            data.position(80);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 75);
        }

        public void set_name(String val) {
            data.position(80);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 75);
        }

        
    
        public int get_inst_term() {
            data.position(156);
            return data.getInt();
        }

        public void set_inst_term(int val) {
            data.position(156);
            data.putInt(val);
        }

        
    
        public String get_code_vcb() {
            data.position(160);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(160);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public byte get_is_limited() {
            data.position(186);
            return data.get();
        }

        public void set_is_limited(byte val) {
            data.position(186);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_old_kotir() {
            data.position(187);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_old_kotir(java.math.BigDecimal val) {
            data.position(187);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_old_kotir_scale() {
            data.position(187);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_roundto() {
            data.position(200);
            return data.getInt();
        }

        public void set_roundto(int val) {
            data.position(200);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_min_step() {
            data.position(204);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_min_step(java.math.BigDecimal val) {
            data.position(204);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_min_step_scale() {
            data.position(204);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_lot_volume() {
            data.position(216);
            return data.getInt();
        }

        public void set_lot_volume(int val) {
            data.position(216);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_step_price() {
            data.position(220);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price(java.math.BigDecimal val) {
            data.position(220);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_scale() {
            data.position(220);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_d_pg() {
            data.position(232);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_pg(java.util.Date val) {
            data.position(232);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_is_spread() {
            data.position(242);
            return data.get();
        }

        public void set_is_spread(byte val) {
            data.position(242);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_coeff() {
            data.position(243);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_coeff(java.math.BigDecimal val) {
            data.position(243);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d9.6", val);
        }

        
        public byte get_coeff_scale() {
            data.position(243);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_d_exp() {
            data.position(250);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_exp(java.util.Date val) {
            data.position(250);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_is_percent() {
            data.position(260);
            return data.get();
        }

        public void set_is_percent(byte val) {
            data.position(260);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_percent_rate() {
            data.position(261);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_percent_rate(java.math.BigDecimal val) {
            data.position(261);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d6.2", val);
        }

        
        public byte get_percent_rate_scale() {
            data.position(261);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_last_cl_quote() {
            data.position(266);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_last_cl_quote(java.math.BigDecimal val) {
            data.position(266);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_last_cl_quote_scale() {
            data.position(266);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_signs() {
            data.position(280);
            return data.getInt();
        }

        public void set_signs(int val) {
            data.position(280);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_volat_min() {
            data.position(284);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_volat_min(java.math.BigDecimal val) {
            data.position(284);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d20.15", val);
        }

        
        public byte get_volat_min_scale() {
            data.position(284);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_volat_max() {
            data.position(297);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_volat_max(java.math.BigDecimal val) {
            data.position(297);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d20.15", val);
        }

        
        public byte get_volat_max_scale() {
            data.position(297);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_price_dir() {
            data.position(310);
            return data.get();
        }

        public void set_price_dir(byte val) {
            data.position(310);
            data.put(val);
        }

        
    
        public int get_multileg_type() {
            data.position(312);
            return data.getInt();
        }

        public void set_multileg_type(int val) {
            data.position(312);
            data.putInt(val);
        }

        
    
        public int get_legs_qty() {
            data.position(316);
            return data.getInt();
        }

        public void set_legs_qty(int val) {
            data.position(316);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_step_price_clr() {
            data.position(320);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price_clr(java.math.BigDecimal val) {
            data.position(320);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_clr_scale() {
            data.position(320);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_step_price_interclr() {
            data.position(331);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price_interclr(java.math.BigDecimal val) {
            data.position(331);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_interclr_scale() {
            data.position(331);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_step_price_curr() {
            data.position(342);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price_curr(java.math.BigDecimal val) {
            data.position(342);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_curr_scale() {
            data.position(342);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_d_start() {
            data.position(354);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_start(java.util.Date val) {
            data.position(354);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    


    }

    public static final class diler
    {
        public static final int TABLE_INDEX = 12;
        
	public static final int MSG_SIZE = 296;
        private java.nio.ByteBuffer data;

        public diler() {
            
        }

        public diler(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_client_code() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_name() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 200);
        }

        public void set_name(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 200);
        }

        
    
        public String get_rts_code() {
            data.position(233);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 50);
        }

        public void set_rts_code(String val) {
            data.position(233);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 50);
        }

        
    
        public String get_transfer_code() {
            data.position(284);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_transfer_code(String val) {
            data.position(284);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public int get_status() {
            data.position(292);
            return data.getInt();
        }

        public void set_status(int val) {
            data.position(292);
            data.putInt(val);
        }

        
    


    }

    public static final class investr
    {
        public static final int TABLE_INDEX = 13;
        
	public static final int MSG_SIZE = 240;
        private java.nio.ByteBuffer data;

        public investr() {
            
        }

        public investr(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_client_code() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_name() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 200);
        }

        public void set_name(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 200);
        }

        
    
        public int get_status() {
            data.position(236);
            return data.getInt();
        }

        public void set_status(int val) {
            data.position(236);
            data.putInt(val);
        }

        
    


    }

    public static final class fut_sess_settl
    {
        public static final int TABLE_INDEX = 14;
        
	public static final int MSG_SIZE = 79;
        private java.nio.ByteBuffer data;

        public fut_sess_settl() {
            
        }

        public fut_sess_settl(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public java.util.Date get_date_clr() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date_clr(java.util.Date val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public String get_isin() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(38);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_isin_id() {
            data.position(64);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(64);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_settl_price() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_settl_price(java.math.BigDecimal val) {
            data.position(68);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_settl_price_scale() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class sys_messages
    {
        public static final int TABLE_INDEX = 15;
        
	public static final int MSG_SIZE = 305;
        private java.nio.ByteBuffer data;

        public sys_messages() {
            
        }

        public sys_messages(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_msg_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_msg_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public java.util.Date get_moment() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public String get_lang_code() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 8);
        }

        public void set_lang_code(String val) {
            data.position(38);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 8);
        }

        
    
        public byte get_urgency() {
            data.position(47);
            return data.get();
        }

        public void set_urgency(byte val) {
            data.position(47);
            data.put(val);
        }

        
    
        public byte get_status() {
            data.position(48);
            return data.get();
        }

        public void set_status(byte val) {
            data.position(48);
            data.put(val);
        }

        
    
        public String get_text() {
            data.position(49);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_text(String val) {
            data.position(49);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    


    }

    public static final class rates
    {
        public static final int TABLE_INDEX = 16;
        
	public static final int MSG_SIZE = 71;
        private java.nio.ByteBuffer data;

        public rates() {
            
        }

        public rates(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public int get_rate_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_rate_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public String get_curr_base() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 15);
        }

        public void set_curr_base(String val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 15);
        }

        
    
        public String get_curr_coupled() {
            data.position(44);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 15);
        }

        public void set_curr_coupled(String val) {
            data.position(44);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 15);
        }

        
    
        public java.math.BigDecimal get_radius() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_radius(java.math.BigDecimal val) {
            data.position(60);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_radius_scale() {
            data.position(60);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class sys_events
    {
        public static final int TABLE_INDEX = 17;
        
	public static final int MSG_SIZE = 105;
        private java.nio.ByteBuffer data;

        public sys_events() {
            
        }

        public sys_events(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public long get_event_id() {
            data.position(24);
            return data.getLong();
        }

        public void set_event_id(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(32);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(32);
            data.putInt(val);
        }

        
    
        public int get_event_type() {
            data.position(36);
            return data.getInt();
        }

        public void set_event_type(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 64);
        }

        public void set_message(String val) {
            data.position(40);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 64);
        }

        
    


    }

}

