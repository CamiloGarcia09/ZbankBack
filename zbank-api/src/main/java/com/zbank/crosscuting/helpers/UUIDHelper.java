package com.zbank.crosscuting.helpers;
import java.util.Random;
import java.util.UUID;

public class UUIDHelper {

	public static final UUID UUIDDEFECTO = new UUID(0L, 0L);
	
	private UUIDHelper() {
		super();
	}
	
	public static UUID generarUUIDDefecto() {
        return new UUID(0L, 0L);
    }
	
	public static UUID convertirStringaUUID(String uuidString) {
            return UUID.fromString(uuidString);        
    }
	
	public static UUID generarUUIDAleatorio() {
		Random random = new Random();
        long mas = random.nextLong();
        long menos = random.nextLong();
        return new UUID(mas, menos);
    }
	
	public static final boolean isNull(final UUID uuid) {
		return (uuid == null) || (uuid == UUIDDEFECTO);
	}
	
	public static final UUID obtenerValorDefecto(final UUID uuid, final UUID valorDefecto) {		
		return isNull(uuid) ? valorDefecto: uuid;
	}
	public static final UUID obtenerValorDefecto(final UUID uuid) {		
		return obtenerValorDefecto(uuid, UUIDDEFECTO);
	}
}