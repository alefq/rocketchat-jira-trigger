package se.gustavkarlsson.rocketchat.jira_trigger.configuration;

import com.moandjiezana.toml.Toml;

import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notNull;

public class RocketChatConfiguration {
	private static final String TOKENS_KEY = "tokens";
	private static final String WHITELISTED_USERS = "whitelisted_users";
	private static final String BLACKLISTED_USERS = "blacklisted_users";
	private static final String WHITELISTED_CHANNELS = "whitelisted_channels";
	private static final String BLACKLISTED_CHANNELS = "blacklisted_channels";

	private final Set<String> tokens;
	private final Set<String> whitelistedUsers;
	private final Set<String> blacklistedUsers;
	private final Set<String> whitelistedChannels;
	private final Set<String> blacklistedChannels;

	RocketChatConfiguration(Toml toml) throws ValidationException {
		notNull(toml);
		try {
			tokens = new HashSet<>(toml.getList(TOKENS_KEY));
			whitelistedUsers = new HashSet<>(toml.getList(WHITELISTED_USERS));
			blacklistedUsers = new HashSet<>(toml.getList(BLACKLISTED_USERS));
			whitelistedChannels = new HashSet<>(toml.getList(WHITELISTED_CHANNELS));
			blacklistedChannels = new HashSet<>(toml.getList(BLACKLISTED_CHANNELS));
		} catch (Exception e) {
			throw new ValidationException(e);
		}
	}

	public Set<String> getTokens() {
		return tokens;
	}

	public Set<String> getWhitelistedUsers() {
		return whitelistedUsers;
	}

	public Set<String> getBlacklistedUsers() {
		return blacklistedUsers;
	}

	public Set<String> getWhitelistedChannels() {
		return whitelistedChannels;
	}

	public Set<String> getBlacklistedChannels() {
		return blacklistedChannels;
	}
}
