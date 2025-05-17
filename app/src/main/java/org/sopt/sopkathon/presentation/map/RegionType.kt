import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect

enum class RegionTag(
    val label: String,
    val centerRatio: Offset,
    val rectPx: Rect // 클릭 영역(px) 지정
) {
    BONGHWA("봉화", Offset(594f / 1080f, 160f / 2280f), Rect(580f, 140f, 610f, 180f)),
    DONGJIN("동진", Offset(994f / 1080f, 160f / 2280f), Rect(980f, 140f, 1010f, 180f)),
    YEONGYANG("영양", Offset(886f / 1080f, 456f / 2280f), Rect(870f, 440f, 900f, 470f)),
    YEONGDEOK("영덕", Offset(940f / 1080f, 730f / 2280f), Rect(920f, 710f, 960f, 750f)),
    POHANG("포항", Offset(864f / 1080f, 1094f / 2280f), Rect(850f, 1070f, 880f, 1110f)),
    CHEONGSONG("청송", Offset(778f / 1080f, 775f / 2280f), Rect(760f, 755f, 790f, 795f)),
    ANDONG("안동", Offset(594f / 1080f, 570f / 2280f), Rect(580f, 550f, 610f, 590f)),
    YEONGJU("영주", Offset(454f / 1080f, 296f / 2280f), Rect(440f, 280f, 470f, 310f)),
    MUNGYEONG("문경", Offset(216f / 1080f, 319f / 2280f), Rect(200f, 300f, 230f, 340f)),
    SANGJU("상주", Offset(162f / 1080f, 593f / 2280f), Rect(150f, 570f, 180f, 610f)),
    GIMCHEON("김천", Offset(108f / 1080f, 912f / 2280f), Rect(100f, 890f, 120f, 930f)),
    GUMI("구미", Offset(302f / 1080f, 866f / 2280f), Rect(290f, 850f, 320f, 880f)),
    GUNWI("군위", Offset(454f / 1080f, 1026f / 2280f), Rect(440f, 1000f, 470f, 1050f)),
    CHILGOK("칠곡", Offset(302f / 1080f, 1140f / 2280f), Rect(290f, 1120f, 320f, 1160f)),
    GORYEONG("고령", Offset(194f / 1080f, 1482f / 2280f), Rect(180f, 1460f, 210f, 1500f)),
    DAEGU("대구", Offset(410f / 1080f, 1368f / 2280f), Rect(400f, 1340f, 430f, 1390f)),
    GYEONGSAN("경산", Offset(540f / 1080f, 1482f / 2280f), Rect(530f, 1460f, 560f, 1500f)),
    CHEONGDO("청도", Offset(486f / 1080f, 1710f / 2280f), Rect(470f, 1680f, 500f, 1730f)),
    GYEONGJU("경주", Offset(810f / 1080f, 1550f / 2280f), Rect(800f, 1500f, 850f, 1600f)),
    YEONGCHEON("영천", Offset(648f / 1080f, 1254f / 2280f), Rect(630f, 1230f, 670f, 1280f)),
    HWASEONG("화성", Offset(518f / 1080f, 775f / 2280f), Rect(500f, 750f, 530f, 800f)),
    YESAN("예천", Offset(324f / 1080f, 502f / 2280f), Rect(310f, 480f, 340f, 520f)),
    SUNGJU("성주", Offset(270f / 1080f, 228f / 2280f), Rect(260f, 210f, 280f, 250f))
}
