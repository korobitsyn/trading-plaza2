package trading.app.adapter.plaza2.scheme;

public final class Vm
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class fut_vm
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 62;
        private java.nio.ByteBuffer data;

        public fut_vm() {
            
        }

        public fut_vm(java.nio.ByteBuffer data) {
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

        
    
        public String get_client_code() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.math.BigDecimal get_vm() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm(java.math.BigDecimal val) {
            data.position(40);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_vm_scale() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vm_real() {
            data.position(51);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm_real(java.math.BigDecimal val) {
            data.position(51);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_vm_real_scale() {
            data.position(51);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class opt_vm
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 62;
        private java.nio.ByteBuffer data;

        public opt_vm() {
            
        }

        public opt_vm(java.nio.ByteBuffer data) {
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

        
    
        public String get_client_code() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.math.BigDecimal get_vm() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm(java.math.BigDecimal val) {
            data.position(40);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_vm_scale() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_vm_real() {
            data.position(51);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm_real(java.math.BigDecimal val) {
            data.position(51);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_vm_real_scale() {
            data.position(51);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

}

