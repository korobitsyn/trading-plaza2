package trading.app.adapter.plaza2.scheme;

public final class Clr
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class money_clearing
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 129;
        private java.nio.ByteBuffer data;

        public money_clearing() {
            
        }

        public money_clearing(java.nio.ByteBuffer data) {
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

        
    
        public byte get_share() {
            data.position(32);
            return data.get();
        }

        public void set_share(byte val) {
            data.position(32);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_amount_beg() {
            data.position(33);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_amount_beg(java.math.BigDecimal val) {
            data.position(33);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_amount_beg_scale() {
            data.position(33);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vm() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm(java.math.BigDecimal val) {
            data.position(43);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vm_scale() {
            data.position(43);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_premium() {
            data.position(53);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_premium(java.math.BigDecimal val) {
            data.position(53);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_premium_scale() {
            data.position(53);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_pay() {
            data.position(63);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_pay(java.math.BigDecimal val) {
            data.position(63);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_pay_scale() {
            data.position(63);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_fut() {
            data.position(73);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_fut(java.math.BigDecimal val) {
            data.position(73);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_fut_scale() {
            data.position(73);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_opt() {
            data.position(83);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_opt(java.math.BigDecimal val) {
            data.position(83);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_opt_scale() {
            data.position(83);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_go() {
            data.position(93);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_go(java.math.BigDecimal val) {
            data.position(93);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_go_scale() {
            data.position(93);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_amount_end() {
            data.position(103);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_amount_end(java.math.BigDecimal val) {
            data.position(103);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d21.2", val);
        }

        
        public byte get_amount_end_scale() {
            data.position(103);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_free() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_free(java.math.BigDecimal val) {
            data.position(116);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d22.2", val);
        }

        
        public byte get_free_scale() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class clr_rate
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 64;
        private java.nio.ByteBuffer data;

        public clr_rate() {
            
        }

        public clr_rate(java.nio.ByteBuffer data) {
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

        
    
        public String get_id() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 12);
        }

        public void set_id(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 12);
        }

        
    
        public java.math.BigDecimal get_rate() {
            data.position(37);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_rate(java.math.BigDecimal val) {
            data.position(37);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_rate_scale() {
            data.position(37);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_moment() {
            data.position(48);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(48);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_signs() {
            data.position(58);
            return data.get();
        }

        public void set_signs(byte val) {
            data.position(58);
            data.put(val);
        }

        
    
        public int get_sess_id() {
            data.position(60);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(60);
            data.putInt(val);
        }

        
    


    }

    public static final class fut_pos
    {
        public static final int TABLE_INDEX = 2;
        
	public static final int MSG_SIZE = 146;
        private java.nio.ByteBuffer data;

        public fut_pos() {
            
        }

        public fut_pos(java.nio.ByteBuffer data) {
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

        
    
        public int get_sess_id() {
            data.position(28);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(28);
            data.putInt(val);
        }

        
    
        public String get_isin() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_client_code() {
            data.position(58);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(58);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public byte get_account() {
            data.position(66);
            return data.get();
        }

        public void set_account(byte val) {
            data.position(66);
            data.put(val);
        }

        
    
        public int get_pos_beg() {
            data.position(68);
            return data.getInt();
        }

        public void set_pos_beg(int val) {
            data.position(68);
            data.putInt(val);
        }

        
    
        public int get_pos_end() {
            data.position(72);
            return data.getInt();
        }

        public void set_pos_end(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_vm() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm(java.math.BigDecimal val) {
            data.position(76);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vm_scale() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee() {
            data.position(86);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee(java.math.BigDecimal val) {
            data.position(86);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_scale() {
            data.position(86);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_accum_go() {
            data.position(96);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_accum_go(java.math.BigDecimal val) {
            data.position(96);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_accum_go_scale() {
            data.position(96);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_ex() {
            data.position(106);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_ex(java.math.BigDecimal val) {
            data.position(106);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_ex_scale() {
            data.position(106);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vat_ex() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vat_ex(java.math.BigDecimal val) {
            data.position(116);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vat_ex_scale() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_cc() {
            data.position(126);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_cc(java.math.BigDecimal val) {
            data.position(126);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_cc_scale() {
            data.position(126);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vat_cc() {
            data.position(136);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vat_cc(java.math.BigDecimal val) {
            data.position(136);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vat_cc_scale() {
            data.position(136);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class opt_pos
    {
        public static final int TABLE_INDEX = 3;
        
	public static final int MSG_SIZE = 136;
        private java.nio.ByteBuffer data;

        public opt_pos() {
            
        }

        public opt_pos(java.nio.ByteBuffer data) {
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

        
    
        public int get_sess_id() {
            data.position(28);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(28);
            data.putInt(val);
        }

        
    
        public String get_isin() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_client_code() {
            data.position(58);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(58);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public byte get_account() {
            data.position(66);
            return data.get();
        }

        public void set_account(byte val) {
            data.position(66);
            data.put(val);
        }

        
    
        public int get_pos_beg() {
            data.position(68);
            return data.getInt();
        }

        public void set_pos_beg(int val) {
            data.position(68);
            data.putInt(val);
        }

        
    
        public int get_pos_end() {
            data.position(72);
            return data.getInt();
        }

        public void set_pos_end(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_vm() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm(java.math.BigDecimal val) {
            data.position(76);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vm_scale() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee() {
            data.position(86);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee(java.math.BigDecimal val) {
            data.position(86);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_scale() {
            data.position(86);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_ex() {
            data.position(96);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_ex(java.math.BigDecimal val) {
            data.position(96);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_ex_scale() {
            data.position(96);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vat_ex() {
            data.position(106);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vat_ex(java.math.BigDecimal val) {
            data.position(106);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vat_ex_scale() {
            data.position(106);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_fee_cc() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_fee_cc(java.math.BigDecimal val) {
            data.position(116);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_fee_cc_scale() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vat_cc() {
            data.position(126);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vat_cc(java.math.BigDecimal val) {
            data.position(126);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vat_cc_scale() {
            data.position(126);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class fut_sess_settl
    {
        public static final int TABLE_INDEX = 4;
        
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

    public static final class opt_sess_settl
    {
        public static final int TABLE_INDEX = 5;
        
	public static final int MSG_SIZE = 90;
        private java.nio.ByteBuffer data;

        public opt_sess_settl() {
            
        }

        public opt_sess_settl(java.nio.ByteBuffer data) {
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

        
    
        public java.math.BigDecimal get_volat() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_volat(java.math.BigDecimal val) {
            data.position(68);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_volat_scale() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_theor_price() {
            data.position(79);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_theor_price(java.math.BigDecimal val) {
            data.position(79);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_theor_price_scale() {
            data.position(79);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class sys_events
    {
        public static final int TABLE_INDEX = 6;
        
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

