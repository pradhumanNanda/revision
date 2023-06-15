package com.activity.revision.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.text.similarity.CosineSimilarity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.activity.revision.repo.UserRepo;
import com.activity.revision.requests.ChatRequest;
import com.activity.revision.response.ChatGptResponse;
import com.activity.revision.user.UserDb;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.OpenAiService;

@Service
@SuppressWarnings("unused")
public class ChatBot {

	private UserRepo userRepo;

	private Map<String, String> questionsAnswers = new HashMap<>();

	public ChatBot(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	private ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
			false);

	public Object chat1(ChatRequest chatRequest) throws Exception {

		HttpClient client = HttpClients.createDefault();

		HttpPost request = new HttpPost("https://api.openai.com/v1/chat/completions");

		request.setHeader("Authorization", "Bearer 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");

		request.setHeader("Content-Type", "application/json");

		String requestBody = mapper.writeValueAsString(chatRequest);

		request.setEntity(new StringEntity(requestBody, StandardCharsets.UTF_8));

		HttpResponse response = client.execute(request);

		HttpEntity entity = response.getEntity();

		String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);

		ObjectMapper objectMapper = new ObjectMapper();

		Object jsonObject = objectMapper.readValue(responseBody, Object.class);

		return jsonObject;

	}

	public Object chat2(ChatRequest chatRequest) throws Exception {

		getAnswer();

		String question = chatRequest.getMessages().get(0).getContent();

		if (questionsAnswers.containsKey(question))
			return questionsAnswers.get(question);

		for (String storedQuestion : questionsAnswers.keySet()) {

			if (checkSimilarity(storedQuestion, question, chatRequest)) {
				questionsAnswers.put(question, questionsAnswers.get(storedQuestion));
				return questionsAnswers.get(question);
			}

		}

		return "I don't know";
	}

	public Object chat3(ChatRequest chatRequest) throws Exception {

		HttpClient client = HttpClients.createDefault();

		HttpPost request = new HttpPost("https://api.openai.com/v1/chat/completions");

		request.setHeader("Authorization", "Bearer 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");

		request.setHeader("Content-Type", "application/json");

		String newContent = helper(chatRequest.getMessages().get(0).getContent());

		chatRequest.getMessages().get(0).setContent(newContent);

		String requestBody = mapper.writeValueAsString(chatRequest);

		request.setEntity(new StringEntity(requestBody, StandardCharsets.UTF_8));

		HttpResponse response = client.execute(request);

		HttpEntity entity = response.getEntity();

		String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);

		ChatGptResponse gptResponse = mapper.readValue(responseBody, ChatGptResponse.class);

		return gptResponse.getChoicesList().get(0).getMessage().getContent();
	}

	public String helper(String str) throws Exception {

		String[] arr = str.split(" ");

		Long id = Long.parseLong(arr[arr.length - 1]);

		UserDb userDb = userRepo.findById(id).get();

		return formatData(userDb.toString());
	}

	public String formatData(String user) {

		return "These are the user details asked by the user-" + user
				+ "Generate a response with only the email of the user in readable text fromat";

	}

	public Object getAnswer() throws Exception {

		String jsonContent = new String(
				Files.readAllBytes(Paths.get("/Users/bharatjoshi/Desktop/LogFiles/questions.json")));

		JSONObject jsonObject = new JSONObject(jsonContent);

		Iterator<String> keys = jsonObject.keys();

		while (keys.hasNext()) {
			String question = keys.next();
			String answer = jsonObject.getString(question);
			questionsAnswers.put(question, answer);
		}

		return questionsAnswers;

	}

	public boolean checkSimilarity(String question1, String question2, ChatRequest chatRequest) throws Exception {

		HttpClient client = HttpClients.createDefault();

		HttpPost request = new HttpPost("https://api.openai.com/v1/chat/completions");

		request.setHeader("Authorization", "Bearer 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");

		request.setHeader("Content-Type", "application/json");

		String newContent = "Does these two questions have same answers also check for parameters like emailid, agentid, userid, contactnumbers, these parameters should be same in both to have the same answer : "
				+ question1 + " and " + question2 + "? " + "Just say true Or false without explanations";

		chatRequest.getMessages().get(0).setContent(newContent);

		String requestBody = mapper.writeValueAsString(chatRequest);

		request.setEntity(new StringEntity(requestBody, StandardCharsets.UTF_8));

		HttpResponse response = client.execute(request);

		HttpEntity entity = response.getEntity();

		String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);

		ChatGptResponse gptResponse = mapper.readValue(responseBody, ChatGptResponse.class);

		String res = (String) gptResponse.getChoicesList().get(0).getMessage().getContent();

		return res.contentEquals("True.");

	}

}
