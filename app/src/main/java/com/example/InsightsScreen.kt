package com.example

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.draw.alpha
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.local.entity.UserStatsEntity
import com.example.ui.theme.*

@Composable
fun InsightsScreen(viewModel: PlannerViewModel) {
    val statsState by viewModel.userStats.collectAsStateWithLifecycle()
    val stats = statsState ?: UserStatsEntity(userId = viewModel.currentUserId)

    // Trigger streak checks on open
    LaunchedEffect(Unit) {
        viewModel.updateStreakOnStart()
    }

    val xpNeeded = stats.level * 150
    val progress = if (xpNeeded > 0) stats.xp.toFloat() / xpNeeded.toFloat() else 0f

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
            .padding(horizontal = 24.dp),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text("Insights & Progression", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Slate900)
            Spacer(modifier = Modifier.height(20.dp))
        }

        // 1. Level Progression Banner
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Slate200),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "LEVEL ${stats.level}", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = Indigo700)
                            Text(text = "${stats.xp} / $xpNeeded XP to level up", fontSize = 12.sp, color = Slate500)
                        }
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(Brush.linearGradient(listOf(Indigo600, Purple500))),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    // Progress Bar
                    LinearProgressIndicator(
                        progress = progress,
                        color = Indigo600,
                        trackColor = Slate100,
                        strokeCap = StrokeCap.Round,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                    )
                }
            }
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }

        // 2. Streaks Panel
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, Slate200),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFFF3E0)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🔥", fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text("Daily Streak: ${stats.currentStreak} Days", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Slate900)
                        Text("Keep scheduling tasks and completing daily activities to raise your streak multiplier!", fontSize = 11.sp, color = Slate500)
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }

        // 3. Trophies/Badges Cabinet
        item {
            Text("Your Achievements", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Slate900)
            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            // Display static achievements for demo
            val achievements = listOf(
                AchievementBadge("early_bird", "Early Bird", "Complete a plan before 8:00 AM", "🌅", true),
                AchievementBadge("note_taker", "Note Taker", "Create 10 markdown notes", "📝", true),
                AchievementBadge("unstoppable", "Unstoppable", "Reach a 7-day daily streak", "⚡", false),
                AchievementBadge("planner_pro", "Planner Pro", "Complete 100 total task list items", "🏆", false)
            )

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                achievements.forEach { badge ->
                    Card(
                        colors = CardDefaults.cardColors(containerColor = if (badge.isUnlocked) Color.White else Slate100),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, if (badge.isUnlocked) Slate200 else Color.Transparent),
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(if (badge.isUnlocked) 1.0f else 0.5f)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(CircleShape)
                                    .background(if (badge.isUnlocked) Color(0xFFE8F5E9) else Slate200),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(badge.emoji, fontSize = 20.sp)
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = badge.title,
                                    fontWeight = FontWeight.Bold,
                                    color = if (badge.isUnlocked) Slate900 else Slate500
                                )
                                Text(text = badge.description, fontSize = 11.sp, color = Slate500)
                            }
                        }
                    }
                }
            }
        }
    }
}

data class AchievementBadge(
    val id: String,
    val title: String,
    val description: String,
    val emoji: String,
    val isUnlocked: Boolean
)
