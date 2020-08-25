import net.mamoe.mirai.utils.DeviceInfoData

fun main() {
    DeviceInfoData.serializer()
    val d = DeviceInfoData.serializer()
    print(d)
}