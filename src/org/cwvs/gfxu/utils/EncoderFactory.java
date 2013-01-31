package org.cwvs.gfxu.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 字符转码
 * @author daniel.peng
 *
 */
public abstract class EncoderFactory {

	private static final Logger logger = Logger.getLogger(EncoderFactory.class
			.getName());
	private static final EncoderFactory instance;
	private Map encoders;
	static {
		instance = new EncoderFactory() {
		};
	}

	protected EncoderFactory() {
		encoders = new HashMap();
		registerEncoder(HTML_ENCODER, "default");
		registerEncoder(TEXT_ENCODER, "text");
		registerEncoder(XML_ENCODER, "xml");
		registerEncoder(HTML_ENCODER, "html");
		registerEncoder(NONE_ENCODER, "none");
		registerEncoder(JS_STRING_ENCODER, "json");
	};

	public static EncoderFactory getInstance() {
		return instance;
	}

	public Encoder getEncoder(String name) throws IllegalArgumentException {
		Encoder converter;
		converter = (Encoder) encoders.get(name);
		if (converter == null) {
			try {
				converter = loadEncoder(name, name);
			} catch (Throwable ex) {
				logger.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return converter;
	}

	public boolean hasEncoder(String name) {
		return this.encoders.containsKey(name);
	}

	private Encoder loadEncoder(String className, String key)
			throws IllegalArgumentException {
		synchronized (this.encoders) {
			Encoder converter;
			converter = (Encoder) encoders.get(className);
			if (converter == null) {
				try {
					Class clazz = loadClass(className);
					converter = (Encoder) clazz.newInstance();
				} catch (IllegalAccessException ex) {
					throw new IllegalArgumentException(
							"Could not instance the encoder:" + className, ex);
				} catch (InstantiationException ex) {
					throw new IllegalArgumentException(
							"Could not instance the encoder:" + className, ex);
				} catch (ClassNotFoundException ex) {
					throw new IllegalArgumentException(
							"Could not find the encoder:" + key, ex);
				}
				this.encoders.put(converter, key);
			}
			return converter;
		}
	}

	private Encoder instanceEncoder(String className) throws Exception {
		Encoder converter;
		try {
			Class clazz = loadClass(className);
			converter = (Encoder) clazz.newInstance();
		} catch (IllegalAccessException ex) {
			throw new Exception("Could not instance the encoder:" + className,
					ex);
		} catch (InstantiationException ex) {
			throw new Exception("Could not instance the encoder:" + className,
					ex);
		} catch (ClassNotFoundException ex) {
			throw new Exception(
					"Could not find the encoder class:" + className, ex);
		}
		return converter;
	}

	public void registerEncoder(Encoder converter) {
		registerEncoder(converter, converter.getClass().getName(), false);
	}

	public void registerEncoder(Encoder converter, String key) {
		registerEncoder(converter, key, false);
	}

	public void registerEncoder(Encoder converter, String key, boolean overwrite) {
		if (key == null || converter == null) {
			throw new NullPointerException();
		}
		synchronized (this.encoders) {
			if (this.encoders.containsKey(key)) {
				if (overwrite) {
					this.encoders.remove(key);
					this.encoders.put(key, converter);
				} else {
					boolean overIt = false;
					// check if it overs the default setting
					if ("default".equals(key)) {
						Encoder t = (Encoder) this.encoders.get(key);
						if (t == HTML_ENCODER) {
							this.encoders.remove(key);
							this.encoders.put(key, converter);
							overIt = true;
						}
					} else if ("none".equals(key)) {
						Encoder t = (Encoder) this.encoders.get(key);
						if (t == NONE_ENCODER) {
							this.encoders.remove(key);
							this.encoders.put(key, converter);
							overIt = true;
						}
					} else if ("xml".equals(key)) {
						Encoder t = (Encoder) this.encoders.get(key);
						if (t == XML_ENCODER) {
							this.encoders.remove(key);
							this.encoders.put(key, converter);
							overIt = true;
						}
					} else if ("html".equals(key)) {
						Encoder t = (Encoder) this.encoders.get(key);
						if (t == HTML_ENCODER) {
							this.encoders.remove(key);
							this.encoders.put(key, converter);
							overIt = true;
						}
					} else if ("text".equals(key)) {
						Encoder t = (Encoder) this.encoders.get(key);
						if (t == TEXT_ENCODER) {
							this.encoders.remove(key);
							this.encoders.put(key, converter);
							overIt = true;
						}
					}
					if (!overIt) {
						throw new IllegalArgumentException(
								"Could not duplicate register the encoder:\""
										+ converter.getClass().getName()
										+ "\" for key:\"" + key + "\"");
					}
				}
			} else {
				this.encoders.put(key, converter);
			}
		}
	}

	private Class loadClass(String className) throws ClassNotFoundException {
		try {
			ClassLoader contextClassLoader = Thread.currentThread()
					.getContextClassLoader();
			if (contextClassLoader != null) {
				return contextClassLoader.loadClass(className);
			} else {
				return Class.forName(className);
			}
		} catch (Exception e) {
			return Class.forName(className);
		}
	}

	public final Encoder TEXT_ENCODER = new Encoder() {
		private String name = "text";

		public String getName() {
			return name;
		}

		public String encode(String source) {
			int l;
			if (source == null || (l = source.length()) == 0)
				return source;
			StringBuilder result = null;
			String filtered = null;
			int lastSpaceIndex = -1;
			for (int i = 0; i < l; i++) {
				switch (source.charAt(i)) {
				case '<':
					filtered = "&#60;";
					break;
				case '>':
					filtered = "&#62;";
					break;
				case '\'':
					filtered = "&#39;";
					break;
				case '\"':
					filtered = "&#34;";
					break;
				case ' ':
					if (lastSpaceIndex == i - 1 || i >= l - 1) {
						filtered = "&nbsp;";
					} else {
						lastSpaceIndex = i;
						filtered = null;
					}
					// lastSpaceIndex = i;
					break;
				case '&': // &
					filtered = "&#38;";
					break;
				case '\n':
					if (i > 1 && source.charAt(i - 1) == '\r') {
						filtered = "";
					} else {
						filtered = "<br>";
					}
					// set space index
					lastSpaceIndex = i;
					break;
				case '\r':
					filtered = "<br>";
					break;
				// case '\t': //tab key
				// filtered = "&#09;";
				// break;
				default:
					filtered = null;
				}
				if (result == null) {
					if (filtered != null) {
						result = new StringBuilder(l + 50);
						if (i > 0) {
							result.append(source.substring(0, i));
						}
						result.append(filtered);
					}
				} else {
					if (filtered == null) {
						result.append(source.charAt(i));
					} else {
						result.append(filtered);
					}
				}
			}
			return result == null ? source : result.toString();

		}
	};
	public final Encoder HTML_ENCODER = new Encoder() {
		private String name = "html";

		public String getName() {
			return name;
		}

		public String encode(String source) {
			int l;
			if (source == null || (l = source.length()) == 0)
				return source;
			StringBuilder result = null;
			String filtered = null;
			for (int i = 0; i < l; i++) {
				switch (source.charAt(i)) {
				case '&': // &
					filtered = "&#38;";
					break;
				case '#': // #
					filtered = "&#35;";
					break;
				case '\"':
					filtered = "&#34;";
					break;
				case '<':
					filtered = "&#60;";
					break;
				case '>':
					filtered = "&#62;";
					break;
				case '\'':
					filtered = "&#39;";
					break;
				default:
					filtered = null;
				}
				if (result == null) {
					if (filtered != null) {
						result = new StringBuilder(l + 20);
						if (i > 0) {
							result.append(source.substring(0, i));
						}
						result.append(filtered);
					}
				} else {
					if (filtered == null) {
						result.append(source.charAt(i));
					} else {
						result.append(filtered);
					}
				}
			}
			return result == null ? source : result.toString();

		}
	};

	public final Encoder XML_ENCODER = new Encoder() {
		private String name = "xml";

		public String getName() {
			return name;
		}

		public String encode(String source) {
			int l;
			if (source == null || (l = source.length()) == 0)
				return source;
			StringBuilder result = null;
			String filtered = null;
			for (int i = 0; i < l; i++) {
				switch (source.charAt(i)) {
				case '&': // &
					filtered = "&#38;";
					break;
				case '\"':
					filtered = "&#34;";
					break;
				case '<':
					filtered = "&#60;";
					break;
				case '>':
					filtered = "&#62;";
					break;
				case '\'':
					filtered = "&#39;";
					break;
				default:
					filtered = null;
				}
				if (result == null) {
					if (filtered != null) {
						result = new StringBuilder(l + 20);
						if (i > 0) {
							result.append(source.substring(0, i));
						}
						result.append(filtered);
					}
				} else {
					if (filtered == null) {
						result.append(source.charAt(i));
					} else {
						result.append(filtered);
					}
				}
			}
			return result == null ? source : result.toString();

		}
	};

	public final Encoder JS_STRING_ENCODER = new Encoder() {
		private String name = "json";

		public String getName() {
			return name;
		}

		public String encode(String source) {
			int l;
			if (source == null || (l = source.length()) == 0)
				return source;
			StringBuilder result = null;
			String filtered = null;
			for (int i = 0; i < l; i++) {
				switch (source.charAt(i)) {
				case '\"': // &
					filtered = "\\\"";
					break;
				case '\'':
					filtered = "\\'";
					break;
				case '\n':
					filtered = "\\n";
					break;
				case '\t':
					filtered = "\\t";
					break;
				case '\r':
					filtered = "\\r";
					break;
				case '\\':
					filtered = "\\\\";
					break;
				case '\b':
					filtered = "\\b";
					break;
				case '/':
					filtered = "\\/";
					break;
				default:
					filtered = null;
				}
				if (result == null) {
					if (filtered != null) {
						result = new StringBuilder(l + 20);
						if (i > 0) {
							result.append(source.substring(0, i));
						}
						result.append(filtered);
					}
				} else {
					if (filtered == null) {
						result.append(source.charAt(i));
					} else {
						result.append(filtered);
					}
				}
			}
			return result == null ? source : result.toString();

		}
	};

	public final Encoder NONE_ENCODER = new Encoder() {
		private String name = "none";

		public String getName() {
			return name;
		}

		public String encode(String source) {
			return source;
		}
	};

}
