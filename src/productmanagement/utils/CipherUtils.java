package productmanagement.utils;

import java.util.ArrayList;
import java.util.List;

public class CipherUtils {

	// Tạo một ký tự ngẫu nhiên từ 'a' đến 'f' hoặc từ '0' đến '9'
	public static char fixedHexChar(char lastChar) {
		if (lastChar >= '0' && lastChar <= '8') {
			return (char) (lastChar + 1); // Tăng lên một nếu lastChar là 0-8
		} else if (lastChar == '9') {
			return 'a'; // Nếu lastChar là 9, trả về 'a'
		} else if (lastChar >= 'a' && lastChar <= 'e') {
			return (char) (lastChar + 1); // Tăng lên một nếu lastChar là a-e
		} else {
			return '0'; // Nếu lastChar là 'f', trả về '0'
		}
	}

	// Phương thức chuyển đổi một chuỗi thành một chuỗi các giá trị Unicode ở dạng
	// thập lục phân
	public static String vanBanSangThapLucPhan(String vanBan) {
		StringBuilder thapLucPhan = new StringBuilder();
		for (int i = 0; i < vanBan.length(); i++) {
			char c = vanBan.charAt(i);
			int unicode = c;
			thapLucPhan.append(String.format("%04x", unicode));
		}
		return thapLucPhan.toString();
	}

	public static String chuoiThem(String vanBan) {
		StringBuilder chuoiThem = new StringBuilder();
		String hexString = vanBanSangThapLucPhan(vanBan);
		int i = hexString.length();
		while (i % 32 != 0) {
			char lastChar = hexString.charAt(hexString.length() - 1);
			char fixedChar = fixedHexChar(lastChar);
			chuoiThem.append(fixedChar);

			i++;
		}
		return chuoiThem.toString();
	}

	public static String themThapLuc(String vanBan, String chuoiThem) {
		StringBuilder themThapLuc = new StringBuilder();
		themThapLuc.append(vanBanSangThapLucPhan(vanBan));
		themThapLuc.append(chuoiThem);
		return themThapLuc.toString();
	}

	// Hàm xóa các phần tử giống nhau ở cuối chuỗi đến khi gặp phần tử khác
	public static String xoaPhanTuCuoi(String chuoi) {
		if (chuoi == null || chuoi.length() == 0) {
			return chuoi;
		}

		char lastChar = chuoi.charAt(chuoi.length() - 1);
		int index = chuoi.length() - 1;
		int i = 0;
		// Tìm vị trí của phần tử khác đầu tiên từ cuối chuỗi
		while (index >= 0 && chuoi.charAt(index) == lastChar) {
			index--;
			i++;
		}
		if (i == 1)
			return chuoi;
		else
			// Trả về chuỗi đến vị trí khác đầu tiên
			return chuoi.substring(0, index + 1);
	}

	// Phương thức chia chuỗi thành các chuỗi có 32 ký tự
	public static List<String> chiaChuoiThanh32KyTu(String hexString) {
		List<String> chunks = new ArrayList<>();
		for (int i = 0; i < hexString.length(); i += 32) {
			int endIndex = Math.min(i + 32, hexString.length());
			chunks.add(hexString.substring(i, endIndex));
		}
		return chunks;
	}

	public static byte[] hexStringToByteArray(String hexString) {
		int len = hexString.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
					+ Character.digit(hexString.charAt(i + 1), 16));
		}
		return data;
	}

	// Phương thức thay thế byte sử dụng S-box
	private static byte substituteByte(byte b) {
		byte[] sBox = { (byte) 0x63, (byte) 0x7C, (byte) 0x77, (byte) 0x7B, (byte) 0xF2, (byte) 0x6B, (byte) 0x6F,
				(byte) 0xC5, (byte) 0x30, (byte) 0x01, (byte) 0x67, (byte) 0x2B, (byte) 0xFE, (byte) 0xD7, (byte) 0xAB,
				(byte) 0x76, (byte) 0xCA, (byte) 0x82, (byte) 0xC9, (byte) 0x7D, (byte) 0xFA, (byte) 0x59, (byte) 0x47,
				(byte) 0xF0, (byte) 0xAD, (byte) 0xD4, (byte) 0xA2, (byte) 0xAF, (byte) 0x9C, (byte) 0xA4, (byte) 0x72,
				(byte) 0xC0, (byte) 0xB7, (byte) 0xFD, (byte) 0x93, (byte) 0x26, (byte) 0x36, (byte) 0x3F, (byte) 0xF7,
				(byte) 0xCC, (byte) 0x34, (byte) 0xA5, (byte) 0xE5, (byte) 0xF1, (byte) 0x71, (byte) 0xD8, (byte) 0x31,
				(byte) 0x15, (byte) 0x04, (byte) 0xC7, (byte) 0x23, (byte) 0xC3, (byte) 0x18, (byte) 0x96, (byte) 0x05,
				(byte) 0x9A, (byte) 0x07, (byte) 0x12, (byte) 0x80, (byte) 0xE2, (byte) 0xEB, (byte) 0x27, (byte) 0xB2,
				(byte) 0x75, (byte) 0x09, (byte) 0x83, (byte) 0x2C, (byte) 0x1A, (byte) 0x1B, (byte) 0x6E, (byte) 0x5A,
				(byte) 0xA0, (byte) 0x52, (byte) 0x3B, (byte) 0xD6, (byte) 0xB3, (byte) 0x29, (byte) 0xE3, (byte) 0x2F,
				(byte) 0x84, (byte) 0x53, (byte) 0xD1, (byte) 0x00, (byte) 0xED, (byte) 0x20, (byte) 0xFC, (byte) 0xB1,
				(byte) 0x5B, (byte) 0x6A, (byte) 0xCB, (byte) 0xBE, (byte) 0x39, (byte) 0x4A, (byte) 0x4C, (byte) 0x58,
				(byte) 0xCF, (byte) 0xD0, (byte) 0xEF, (byte) 0xAA, (byte) 0xFB, (byte) 0x43, (byte) 0x4D, (byte) 0x33,
				(byte) 0x85, (byte) 0x45, (byte) 0xF9, (byte) 0x02, (byte) 0x7F, (byte) 0x50, (byte) 0x3C, (byte) 0x9F,
				(byte) 0xA8, (byte) 0x51, (byte) 0xA3, (byte) 0x40, (byte) 0x8F, (byte) 0x92, (byte) 0x9D, (byte) 0x38,
				(byte) 0xF5, (byte) 0xBC, (byte) 0xB6, (byte) 0xDA, (byte) 0x21, (byte) 0x10, (byte) 0xFF, (byte) 0xF3,
				(byte) 0xD2, (byte) 0xCD, (byte) 0x0C, (byte) 0x13, (byte) 0xEC, (byte) 0x5F, (byte) 0x97, (byte) 0x44,
				(byte) 0x17, (byte) 0xC4, (byte) 0xA7, (byte) 0x7E, (byte) 0x3D, (byte) 0x64, (byte) 0x5D, (byte) 0x19,
				(byte) 0x73, (byte) 0x60, (byte) 0x81, (byte) 0x4F, (byte) 0xDC, (byte) 0x22, (byte) 0x2A, (byte) 0x90,
				(byte) 0x88, (byte) 0x46, (byte) 0xEE, (byte) 0xB8, (byte) 0x14, (byte) 0xDE, (byte) 0x5E, (byte) 0x0B,
				(byte) 0xDB, (byte) 0xE0, (byte) 0x32, (byte) 0x3A, (byte) 0x0A, (byte) 0x49, (byte) 0x06, (byte) 0x24,
				(byte) 0x5C, (byte) 0xC2, (byte) 0xD3, (byte) 0xAC, (byte) 0x62, (byte) 0x91, (byte) 0x95, (byte) 0xE4,
				(byte) 0x79, (byte) 0xE7, (byte) 0xC8, (byte) 0x37, (byte) 0x6D, (byte) 0x8D, (byte) 0xD5, (byte) 0x4E,
				(byte) 0xA9, (byte) 0x6C, (byte) 0x56, (byte) 0xF4, (byte) 0xEA, (byte) 0x65, (byte) 0x7A, (byte) 0xAE,
				(byte) 0x08, (byte) 0xBA, (byte) 0x78, (byte) 0x25, (byte) 0x2E, (byte) 0x1C, (byte) 0xA6, (byte) 0xB4,
				(byte) 0xC6, (byte) 0xE8, (byte) 0xDD, (byte) 0x74, (byte) 0x1F, (byte) 0x4B, (byte) 0xBD, (byte) 0x8B,
				(byte) 0x8A, (byte) 0x70, (byte) 0x3E, (byte) 0xB5, (byte) 0x66, (byte) 0x48, (byte) 0x03, (byte) 0xF6,
				(byte) 0x0E, (byte) 0x61, (byte) 0x35, (byte) 0x57, (byte) 0xB9, (byte) 0x86, (byte) 0xC1, (byte) 0x1D,
				(byte) 0x9E, (byte) 0xE1, (byte) 0xF8, (byte) 0x98, (byte) 0x11, (byte) 0x69, (byte) 0xD9, (byte) 0x8E,
				(byte) 0x94, (byte) 0x9B, (byte) 0x1E, (byte) 0x87, (byte) 0xE9, (byte) 0xCE, (byte) 0x55, (byte) 0x28,
				(byte) 0xDF, (byte) 0x8C, (byte) 0xA1, (byte) 0x89, (byte) 0x0D, (byte) 0xBF, (byte) 0xE6, (byte) 0x42,
				(byte) 0x68, (byte) 0x41, (byte) 0x99, (byte) 0x2D, (byte) 0x0F, (byte) 0xB0, (byte) 0x54, (byte) 0xBB,
				(byte) 0x16 };
		return sBox[b & 0xFF];
	}

	// Biến đổi SubBytes
	public static byte[] subBytes(byte[] state) {
		byte[] result = new byte[state.length];
		for (int i = 0; i < state.length; i++) {
			result[i] = substituteByte(state[i]);
		}
		return result;
	}

	private static byte inverseSubstituteByte(byte b) {
		byte[] invSBox = { (byte) 0x52, (byte) 0x09, (byte) 0x6A, (byte) 0xD5, (byte) 0x30, (byte) 0x36, (byte) 0xA5,
				(byte) 0x38, (byte) 0xBF, (byte) 0x40, (byte) 0xA3, (byte) 0x9E, (byte) 0x81, (byte) 0xF3, (byte) 0xD7,
				(byte) 0xFB, (byte) 0x7C, (byte) 0xE3, (byte) 0x39, (byte) 0x82, (byte) 0x9B, (byte) 0x2F, (byte) 0xFF,
				(byte) 0x87, (byte) 0x34, (byte) 0x8E, (byte) 0x43, (byte) 0x44, (byte) 0xC4, (byte) 0xDE, (byte) 0xE9,
				(byte) 0xCB, (byte) 0x54, (byte) 0x7B, (byte) 0x94, (byte) 0x32, (byte) 0xA6, (byte) 0xC2, (byte) 0x23,
				(byte) 0x3D, (byte) 0xEE, (byte) 0x4C, (byte) 0x95, (byte) 0x0B, (byte) 0x42, (byte) 0xFA, (byte) 0xC3,
				(byte) 0x4E, (byte) 0x08, (byte) 0x2E, (byte) 0xA1, (byte) 0x66, (byte) 0x28, (byte) 0xD9, (byte) 0x24,
				(byte) 0xB2, (byte) 0x76, (byte) 0x5B, (byte) 0xA2, (byte) 0x49, (byte) 0x6D, (byte) 0x8B, (byte) 0xD1,
				(byte) 0x25, (byte) 0x72, (byte) 0xF8, (byte) 0xF6, (byte) 0x64, (byte) 0x86, (byte) 0x68, (byte) 0x98,
				(byte) 0x16, (byte) 0xD4, (byte) 0xA4, (byte) 0x5C, (byte) 0xCC, (byte) 0x5D, (byte) 0x65, (byte) 0xB6,
				(byte) 0x92, (byte) 0x6C, (byte) 0x70, (byte) 0x48, (byte) 0x50, (byte) 0xFD, (byte) 0xED, (byte) 0xB9,
				(byte) 0xDA, (byte) 0x5E, (byte) 0x15, (byte) 0x46, (byte) 0x57, (byte) 0xA7, (byte) 0x8D, (byte) 0x9D,
				(byte) 0x84, (byte) 0x90, (byte) 0xD8, (byte) 0xAB, (byte) 0x00, (byte) 0x8C, (byte) 0xBC, (byte) 0xD3,
				(byte) 0x0A, (byte) 0xF7, (byte) 0xE4, (byte) 0x58, (byte) 0x05, (byte) 0xB8, (byte) 0xB3, (byte) 0x45,
				(byte) 0x06, (byte) 0xD0, (byte) 0x2C, (byte) 0x1E, (byte) 0x8F, (byte) 0xCA, (byte) 0x3F, (byte) 0x0F,
				(byte) 0x02, (byte) 0xC1, (byte) 0xAF, (byte) 0xBD, (byte) 0x03, (byte) 0x01, (byte) 0x13, (byte) 0x8A,
				(byte) 0x6B, (byte) 0x3A, (byte) 0x91, (byte) 0x11, (byte) 0x41, (byte) 0x4F, (byte) 0x67, (byte) 0xDC,
				(byte) 0xEA, (byte) 0x97, (byte) 0xF2, (byte) 0xCF, (byte) 0xCE, (byte) 0xF0, (byte) 0xB4, (byte) 0xE6,
				(byte) 0x73, (byte) 0x96, (byte) 0xAC, (byte) 0x74, (byte) 0x22, (byte) 0xE7, (byte) 0xAD, (byte) 0x35,
				(byte) 0x85, (byte) 0xE2, (byte) 0xF9, (byte) 0x37, (byte) 0xE8, (byte) 0x1C, (byte) 0x75, (byte) 0xDF,
				(byte) 0x6E, (byte) 0x47, (byte) 0xF1, (byte) 0x1A, (byte) 0x71, (byte) 0x1D, (byte) 0x29, (byte) 0xC5,
				(byte) 0x89, (byte) 0x6F, (byte) 0xB7, (byte) 0x62, (byte) 0x0E, (byte) 0xAA, (byte) 0x18, (byte) 0xBE,
				(byte) 0x1B, (byte) 0xFC, (byte) 0x56, (byte) 0x3E, (byte) 0x4B, (byte) 0xC6, (byte) 0xD2, (byte) 0x79,
				(byte) 0x20, (byte) 0x9A, (byte) 0xDB, (byte) 0xC0, (byte) 0xFE, (byte) 0x78, (byte) 0xCD, (byte) 0x5A,
				(byte) 0xF4, (byte) 0x1F, (byte) 0xDD, (byte) 0xA8, (byte) 0x33, (byte) 0x88, (byte) 0x07, (byte) 0xC7,
				(byte) 0x31, (byte) 0xB1, (byte) 0x12, (byte) 0x10, (byte) 0x59, (byte) 0x27, (byte) 0x80, (byte) 0xEC,
				(byte) 0x5F, (byte) 0x60, (byte) 0x51, (byte) 0x7F, (byte) 0xA9, (byte) 0x19, (byte) 0xB5, (byte) 0x4A,
				(byte) 0x0D, (byte) 0x2D, (byte) 0xE5, (byte) 0x7A, (byte) 0x9F, (byte) 0x93, (byte) 0xC9, (byte) 0x9C,
				(byte) 0xEF, (byte) 0xA0, (byte) 0xE0, (byte) 0x3B, (byte) 0x4D, (byte) 0xAE, (byte) 0x2A, (byte) 0xF5,
				(byte) 0xB0, (byte) 0xC8, (byte) 0xEB, (byte) 0xBB, (byte) 0x3C, (byte) 0x83, (byte) 0x53, (byte) 0x99,
				(byte) 0x61, (byte) 0x17, (byte) 0x2B, (byte) 0x04, (byte) 0x7E, (byte) 0xBA, (byte) 0x77, (byte) 0xD6,
				(byte) 0x26, (byte) 0xE1, (byte) 0x69, (byte) 0x14, (byte) 0x63, (byte) 0x55, (byte) 0x21, (byte) 0x0C,
				(byte) 0x7D };
		return invSBox[b & 0xFF];
	}

	public static byte[] invSubBytes(byte[] state) {
		byte[] result = new byte[state.length];
		for (int i = 0; i < state.length; i++) {
			result[i] = inverseSubstituteByte(state[i]);
		}
		return result;
	}

	// Biến đổi ShiftRows
	public static byte[] shiftRows(byte[] state) {
		byte[] result = new byte[state.length];
		int n = 4; // Kích thước của ma trận (4x4 cho AES)

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i * n + j] = state[(j + (j + i) % n * n)];
			}
		}

		return result;
	}

	public static byte[] inShiftRows(byte[] state) {
		byte[] result = new byte[state.length];
		int n = (int) Math.sqrt(state.length);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i * n + j] = state[j + ((i - j + n) % n * n)];
			}
		}
		return result;
	}

	// Bảng GF(2^8) cho phép tính toán nhanh

	private static final byte[] gf2 = new byte[256];
	private static final byte[] gf3 = new byte[256];

	static {
		for (int i = 0; i < 256; i++) {
			gf2[i] = (byte) ((i << 1) ^ ((i >> 7) * 0x1B));
			gf3[i] = (byte) (gf2[i] ^ i);
		}
	}

	// Phương thức nhân trong GF(2^8)
	private static byte multiply(byte a, byte b) {
		byte p = 0;
		byte hiBitSet;
		for (int i = 0; i < 8; i++) {
			if ((b & 1) != 0) {
				p ^= a;
			}
			hiBitSet = (byte) (a & 0x80);
			a <<= 1;
			if (hiBitSet != 0) {
				a ^= 0x1B;
			}
			b >>= 1;
		}
		return p;
	}

	// Biến đổi MixColumns
	public static byte[] mixColumns(byte[] state) {
		byte[] result = new byte[state.length];
		int n = state.length / 4;
		for (int i = 0; i < n; i++) {
			byte[] column = new byte[4];
			for (int j = 0; j < 4; j++) {
				column[j] = state[i * 4 + j];
			}
			byte[] mixed = mixSingleColumn(column);
			for (int j = 0; j < 4; j++) {
				result[i * 4 + j] = mixed[j];
			}
		}
		return result;
	}

	// Trộn một cột duy nhất trong biến đổi MixColumns
	private static byte[] mixSingleColumn(byte[] column) {
		byte[] result = new byte[4];
		result[0] = (byte) (multiply((byte) 0x02, column[0]) ^ multiply((byte) 0x03, column[1]) ^ column[2]
				^ column[3]);
		result[1] = (byte) (column[0] ^ multiply((byte) 0x02, column[1]) ^ multiply((byte) 0x03, column[2])
				^ column[3]);
		result[2] = (byte) (column[0] ^ column[1] ^ multiply((byte) 0x02, column[2])
				^ multiply((byte) 0x03, column[3]));
		result[3] = (byte) (multiply((byte) 0x03, column[0]) ^ column[1] ^ column[2]
				^ multiply((byte) 0x02, column[3]));
		return result;
	}

	// Biến đổi Inverse MixColumns
	public static byte[] inMixColumns(byte[] state) {
		byte[] result = new byte[state.length];
		int n = state.length / 4;
		for (int i = 0; i < n; i++) {
			byte[] column = new byte[4];
			for (int j = 0; j < 4; j++) {
				column[j] = state[i * 4 + j];
			}
			byte[] mixed = inMixSingleColumn(column);
			for (int j = 0; j < 4; j++) {
				result[i * 4 + j] = mixed[j];
			}
		}
		return result;
	}

	// Trộn một cột duy nhất trong biến đổi Inverse MixColumns
	private static byte[] inMixSingleColumn(byte[] column) {
		byte[] result = new byte[4];
		result[0] = (byte) (multiply((byte) 0x0E, column[0]) ^ multiply((byte) 0x0B, column[1])
				^ multiply((byte) 0x0D, column[2]) ^ multiply((byte) 0x09, column[3]));
		result[1] = (byte) (multiply((byte) 0x09, column[0]) ^ multiply((byte) 0x0E, column[1])
				^ multiply((byte) 0x0B, column[2]) ^ multiply((byte) 0x0D, column[3]));
		result[2] = (byte) (multiply((byte) 0x0D, column[0]) ^ multiply((byte) 0x09, column[1])
				^ multiply((byte) 0x0E, column[2]) ^ multiply((byte) 0x0B, column[3]));
		result[3] = (byte) (multiply((byte) 0x0B, column[0]) ^ multiply((byte) 0x0D, column[1])
				^ multiply((byte) 0x09, column[2]) ^ multiply((byte) 0x0E, column[3]));
		return result;
	}

	// Biến đổi AddRoundKey
	public static byte[] addRoundKey(byte[] state, byte[] roundKey) {
		byte[] result = new byte[state.length];
		for (int i = 0; i < state.length; i++) {
			result[i] = (byte) (state[i] ^ roundKey[i]);
		}
		return result;
	}

	// Hàm mở rộng khóa cho AES
	public static byte[] keyExpansion(byte[] key) {
		int keyLength = key.length;
		int expandedKeyLength = 176;
		byte[] expandedKey = new byte[expandedKeyLength];
		System.arraycopy(key, 0, expandedKey, 0, keyLength);

		int bytesGenerated = keyLength;
		int rconIteration = 1;
		byte[] temp = new byte[4];

		while (bytesGenerated < expandedKeyLength) {
			System.arraycopy(expandedKey, bytesGenerated - 4, temp, 0, 4);

			if (bytesGenerated % keyLength == 0) {
				temp = keyScheduleCore(temp, rconIteration++);
			}

			for (int i = 0; i < 4; i++) {
				expandedKey[bytesGenerated] = (byte) (expandedKey[bytesGenerated - keyLength] ^ temp[i]);
				bytesGenerated++;
			}
		}

		return expandedKey;
	}

	// Hàm hỗ trợ cho mở rộng khóa
	private static byte[] keyScheduleCore(byte[] in, int rconIteration) {
		// Rotate left
		byte temp = in[0];
		in[0] = in[1];
		in[1] = in[2];
		in[2] = in[3];
		in[3] = temp;

		// Apply S-box
		for (int i = 0; i < 4; i++) {
			in[i] = substituteByte(in[i]);
		}

		// XOR với Rcon
		in[0] ^= rcon(rconIteration);

		return in;
	}

	// Hàm tính giá trị Rcon
	private static byte rcon(int iteration) {
		byte rcon = 1;
		for (int i = 1; i < iteration; i++) {
			rcon = (byte) (multiply((byte) 0x02, rcon));
		}
		return rcon;
	}

	public static byte[] maHoa(byte[] input, byte[] key) {
		byte[] expandedKey = keyExpansion(key);

		byte[] state = addRoundKey(input, key);

		for (int round = 1; round <= 10; round++) {
			state = subBytes(state);
			state = shiftRows(state);
			if (round != 10) {
				state = mixColumns(state);
			}

			byte[] roundKey = new byte[16];
			System.arraycopy(expandedKey, round * 16, roundKey, 0, 16);

			state = addRoundKey(state, roundKey);
		}
		return state;
	}

	public static byte[] giaiMa(byte[] state, byte[] key) {
		byte[] expandedKey = keyExpansion(key);

		for (int round = 10; round >= 1; round--) {
			byte[] roundKey = new byte[16];
			System.arraycopy(expandedKey, round * 16, roundKey, 0, 16);

			state = addRoundKey(state, roundKey);

			if (round != 10) {
				state = inMixColumns(state);
			}

			state = inShiftRows(state);

			state = invSubBytes(state);

		}
		state = addRoundKey(state, key);

		return state;
	}

	public static String byteArrayToHexString(byte[] array) {
		StringBuilder hexString = new StringBuilder();
		for (byte b : array) {
			hexString.append(String.format("%02x", b));
		}
		return hexString.toString();
	}

	public static String botChuoi(String chuoiA, String chuoiB) {
		// Sử dụng phương thức replace() để thay thế chuỗi B bằng một chuỗi trống
		return chuoiA.replace(chuoiB, "");
	}

	// Phương thức để chuyển chuỗi hexa sang chuỗi văn bản
	public static String thapLucPhanSangVanBan(String thapLucPhan) {
		StringBuilder vanBan = new StringBuilder();
		for (int i = 0; i < thapLucPhan.length(); i += 4) {
			String hex = thapLucPhan.substring(i, i + 4);
			int unicode = Integer.parseInt(hex, 16);
			vanBan.append((char) unicode);
		}
		return vanBan.toString();
	}

	public static String encrypt(String vanBan, byte[] key) {
		StringBuilder stringBuilder = new StringBuilder();
		String chuoiThem = chuoiThem(vanBan);
		String vanBanThapLucPhan = themThapLuc(vanBan, chuoiThem);
		List<String> chunks = chiaChuoiThanh32KyTu(vanBanThapLucPhan);
		System.out.println();
		for (String chunk : chunks) {
			byte[] input = hexStringToByteArray(chunk);
			byte[] maHoa = maHoa(input, key);
			String hexString = byteArrayToHexString(maHoa);
			stringBuilder.append(hexString);
		}
		// Khóa 128 bit (16 byte)
		String ketQua = stringBuilder.toString();
		System.out.println(ketQua);
		ketQua = thapLucPhanSangVanBan(ketQua);
//		System.out.println(ketQua);
		return ketQua;
	}

	public static String decrypt(String vanBan, byte[] key) {
		StringBuilder stringBuilder = new StringBuilder();
		vanBan = vanBanSangThapLucPhan(vanBan);
		List<String> chunks = chiaChuoiThanh32KyTu(vanBan);
		for (String chunk : chunks) {
			byte[] output = hexStringToByteArray(chunk);
			byte[] giaiMa = giaiMa(output, key);
			String hexString = byteArrayToHexString(giaiMa);

			stringBuilder.append(hexString);

		}
		// Khóa 128 bit (16 byte)
		String ketQua = stringBuilder.toString();
		String chuoiC = xoaPhanTuCuoi(ketQua);

		String vanBangoc = thapLucPhanSangVanBan(chuoiC);

		return vanBangoc;
	}

	public static byte[] generateRandomKey(String mk) {
		String key = vanBanSangThapLucPhan(mk);
		key = key.replaceAll("0", "");

		if (key.length() > 32) {
			// Nếu key lớn hơn 32 ký tự, lấy 32 ký tự cuối
			key = key.substring(key.length() - 32);
		} else if (key.length() < 32) {
			// Nếu key nhỏ hơn 32 ký tự, thêm đủ ký tự để đạt đủ 32 ký tự
			StringBuilder newKey = new StringBuilder(key);

			while (newKey.length() < 32) {
				char lastChar = key.charAt(key.length() - 1);
				char fixedChar = fixedHexChar(lastChar);
				newKey.append(fixedChar);
				key = newKey.toString();

			}
			System.out.println("Key: " + key);
		}

		// Nếu key dài đúng 32 ký tự, không thay đổi
//        System.out.println("Processed Key: " + key);

		return hexStringToByteArray(key);
	}

	public static void printByteArray(byte[] array) {
		for (byte b : array) {
			System.out.printf("%02x ", b);
		}
		System.out.println();
	}

}