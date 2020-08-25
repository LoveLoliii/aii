import jdk.nashorn.internal.objects.annotations.Property
import net.mamoe.mirai.Bot
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.contact.nameCardOrNick
import net.mamoe.mirai.event.events.MemberMuteEvent
import net.mamoe.mirai.event.events.MemberUnmuteEvent
import net.mamoe.mirai.event.subscribeAlways
import net.mamoe.mirai.event.subscribeMessages
import net.mamoe.mirai.join
import net.mamoe.mirai.message.MessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.utils.BotConfiguration
import java.util.*

suspend fun main(args: Array<String>) {
   // BotConfiguration.loadDeviceInfoJson
    
    val qqId =  2329692460L;
    val password = ""
    val bot = Bot(qqId,password){
        fileBasedDeviceInfo(ClassLoader.getSystemResource("device.json").path)
    }.alsoLogin()
    bot.subscribeMessages {
        "你好" reply "你好"
        case("at me"){
            reply(At(sender as Member) +"geiyepa")
        }
        "吃饭" reply getReply("吃饭")
        ""
          
    }
    bot.subscribeAlways<MemberMuteEvent> {
        it.group.sendMessage(PlainText("恭喜  ${it.member.nameCardOrNick} 喜提禁言套餐一份"))
    }
    bot.subscribeAlways<MemberUnmuteEvent> {
        it.group.sendMessage(PlainText(""))
    }
    bot.join();
}

fun getReply(s: String): String {

    return "吃饭";
}
