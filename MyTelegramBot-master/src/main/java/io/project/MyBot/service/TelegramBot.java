package io.project.MyBot.service;

import io.project.MyBot.config.BotConfig;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private boolean startWait = false; // <- Инициализация булеан переменной в самом начале

    private final BotConfig botConfig;

    public TelegramBot(@Value("${bot.token}") String botToken, BotConfig botConfig) {
        super(botToken);
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public void onUpdateReceived(Update update) {




        if (update.hasMessage() && update.getMessage().hasText() && startWait == false) {
            String messageText = update.getMessage().getText();
            long chatId= update.getMessage().getChatId();


            if (messageText.equals("/start")) {
                starCommandReceived(chatId, update.getMessage().getChat().getFirstName());
            }
            else if (messageText.equals("/Weight")) {
                Weight(chatId);
            }
            else if (messageText.equals("/BenchPress")) {
                BenchPress(chatId);
            }
            else if (messageText.equals("/BoobsInitialWeight")) {
                InitialWeightBoobs(chatId);
            }
            else if (messageText.equals("/BoobsWorkingWeight")) {
                WorkingWeightBoobs(chatId);
            }
            else if (messageText.equals("/BoobsMaxWeight")) {
                MaxWeightBoobs(chatId);
            }
            else if (messageText.equals("/Biceps")) {
                Biceps(chatId);
            }
            else if (messageText.equals("/BicepsInitialWeight")) {
                BicepsInitialWeight(chatId);
            }
            else if (messageText.equals("/BicepsWorkingWeight")) {
                BicepsWorkingWeight(chatId);
            }
            else if (messageText.equals("/BicepsMaxWeight")) {
                BicepsMaxWeight(chatId);
            }
            else if (messageText.equals("/BicepsIsolatedSimulator")) {
                BicepsIsolatedSimulator(chatId);
            }
            else if(messageText.equals("/Legs")) {
                Legs(chatId);
            }
            else if(messageText.equals("/LegsInitialWeight")) {
                LegsInitialWeight(chatId);
            }
            else if(messageText.equals("/LegsWorkingWeight")) {
                LegsWorkingWeight(chatId);
            }
            else if(messageText.equals("/LegsMaxWeight")) {
                LegsMaxWeight(chatId);
            }
            else if(messageText.equals("/LegsWorkingPress")) {
                LegsWorkingPress(chatId);
            }
            else if(messageText.equals("/LegsMaxPress")) {
                LegsMaxPress(chatId);
            }
            else if(messageText.equals("/LegsWorkingFlexion")) {
                LegsWorkingFlexion(chatId);
            }
            else if(messageText.equals("/LegsWorkingExtension")) {
                LegsWorkingExtension(chatId);
            }
            else if(messageText.equals("/Triceps")) {
                Triceps(chatId);
            }
            else if(messageText.equals("/TricepsWorkingWeightFrance")) {
                TricepsWorkingWeightFrance(chatId);
            }
            else if(messageText.equals("/TricepsWorkingWeight")) {
                TricepsWorkingWeight(chatId);
            }
            else if(messageText.equals("/Workout")) {
                Workout(chatId);
            }
            else if(messageText.equals("/PullUps")) {
                PullUps(chatId);
            }
            else if(messageText.equals("/PushUpsOnTheUnevenBars")) {
                PushUpsOnTheUnevenBars(chatId);
            }
            else {
                sendMessage(chatId, "Ничего не говори! Я знаю, что ты не был(а) на тренировке");
            }
            return;
        }
        System.out.println(" Ждём" + update.getMessage());
        startWait = false;
    }

    private void starCommandReceived(long chatId, String firstName){
        String answer = "Привет жим бро, "+ firstName + ", хочешь узнать как ты вырос за время тренировок?! \n" +
                         "\n /BenchPress (Жим лёжа!) \n \n /Biceps (Бицепс) \n \n /Legs (Ноги) \n " +
                         "\n /Triceps(Трицепс) \n \n /Workout (Воркаут) \n \n /Weight (Вес)";
        sendMessage(chatId ,answer);
    }

    private void Weight (long chatId){
        String answer = "Сколько ты весишь могучий Рус!";
        sendMessage(chatId,answer);
        startWait = true;
    }

    private void BenchPress(long chatId){
        String answer = "/BoobsInitialWeight(Начальный вес грудь) \n " +
                        "\n /BoobsWorkingWeight(Рабочий вес на грудь)\n" +
                        "\n /BoobsMaxWeight(Максимальный вес на грудь)";
        sendMessage(chatId,answer);
    }

    private void InitialWeightBoobs(long chatId){
        String answer = "С какого веса ты начал, на жиме лёжа?";
        sendMessage(chatId,answer);
    }

    private void WorkingWeightBoobs(long chatId){
        String answer = "Какой вес рабочий, на жиме лёжа?";
        sendMessage(chatId,answer);
    }

    private void MaxWeightBoobs(long chatId){
        String answer = "Какой вес берёшь на максимум, на жиме лёжа?";
        sendMessage(chatId,answer);
    }

    private void Biceps(long chatId){
        String answer = "/BicepsInitialWeight (Начальный вес бицепс) \n " +
                        "\n /BicepsWorkingWeight (Рабочий вес бицепс) \n " +
                        "\n /BicepsMaxWeight (Максимальный вес бицепс)\n" +
                        "\n /BicepsIsolatedSimulator (Рабочий вес подъём на бицепс в изалированном тренажёре";
        sendMessage(chatId,answer);
    }

    private void BicepsInitialWeight(long chatId){
        String answer = "Какой вес берёшь на максимум, на жиме лёжа?";
        sendMessage(chatId,answer);
    }

    private void BicepsWorkingWeight(long chatId){
        String answer = "Какой вес берёшь на максимум, на жиме лёжа?";
        sendMessage(chatId,answer);
    }

    private void BicepsMaxWeight(long chatId){
        String answer = "Какой вес берёшь на максимум, на жиме лёжа?";
        sendMessage(chatId,answer);
    }

    private void BicepsIsolatedSimulator(long chatId){
        String answer = "Какой вес берёшь на максимум, на жиме лёжа?";
        sendMessage(chatId,answer);
    }

    private void Legs(long chatId){
        String answer = "/LegsInitialWeight(Начальный вес присид) \n " +
                        "\n /LegsWorkingWeight(Рабочий вес присид) \n" +
                        "\n /LegsMaxWeight(Максимальный вес присид) \n" +
                        "\n /LegsWorkingPress(Рабочий вес жим ногам) \n " +
                        "\n /LegsMaxPress(Максимальный вес жим ногам) \n" +
                        "\n /LegsWorkingFlexion(Рабочий вес разгибание ног сидя) \n " +
                        "\n /LegsWorkingExtension(Рабочий вес сгибание ног сидя)";
        sendMessage(chatId,answer);
    }

    private void LegsInitialWeight(long chatId){
        String answer = "С какого веса ты начал, на присиде?";
        sendMessage(chatId,answer);
    }

    private void LegsWorkingWeight(long chatId){
        String answer = "Какой вес рабочий, на присиде?";
        sendMessage(chatId,answer);
    }

    private void LegsMaxWeight(long chatId){
        String answer = "Какой вес берёшь на максимум, на присиде?";
        sendMessage(chatId,answer);
    }

    private void LegsWorkingPress(long chatId){
        String answer = "Какой рабочий вес в жиме ногами?";
        sendMessage(chatId,answer);
    }

    private void LegsMaxPress(long chatId){
        String answer = "Какой максимальный вес в жиме ногами?";
        sendMessage(chatId,answer);
    }

    private void LegsWorkingFlexion(long chatId){
        String answer = " Какой рабочий вес на разгибание ног сидя?";
        sendMessage(chatId,answer);
    }

    private void LegsWorkingExtension(long chatId){
        String answer = "Какой рабочий вес на сгибании ног сидя?";
        sendMessage(chatId,answer);
    }

    private void Triceps(long chatId){
        String answer = "/TricepsWorkingWeightFrance(Рабочий вес фрнцузским хватом трицепс) \n " +
                        "\n /TricepsWorkingWeight(Рогатка рабочий вес трицепс))";
        sendMessage(chatId,answer);
    }

    private void TricepsWorkingWeightFrance(long chatId){
        String answer = "Какой рабочий вес французским жимом на трицепс?";
        sendMessage(chatId,answer);
    }

    private void TricepsWorkingWeight(long chatId){
        String answer = "Какой рабочий вес на разгибании рук стоя(трицепс)?";
        sendMessage(chatId,answer);
    }

    private void Workout(long chatId){
        String answer = "/TricepsWorkingWeightFrance(Подтягивания) \n " +
                "\n /TricepsWorkingWeight(Отжимание на брусьях))";
        sendMessage(chatId,answer);
    }

    private void PullUps(long chatId){
        String answer = "ЖИМ бро сколько делаешь подтягиваний?";
        sendMessage(chatId,answer);
    }

    private void PushUpsOnTheUnevenBars(long chatId){
        String answer = "ЖИМ бро сколько делаешь отжиманий на брусьях?";
        sendMessage(chatId,answer);
    }





    private void sendMessage(long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(textToSend);

        try {
            execute(message);
        }
        catch (TelegramApiException exception){

        }
    }

}
