@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.os.Bundle
import java.io.Serializable
import android.os.Parcelable

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireBoolean(key: String): Boolean = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getBooleanOrNull(key: String): Boolean? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireInt(key: String): Int = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getIntOrNull(key: String): Int? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireLong(key: String): Long = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getLongOrNull(key: String): Long? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireString(key: String): String = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getStringOrNull(key: String): String? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun <reified T : Parcelable> Bundle.requireParcelable(key: String): T = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun <reified T : Parcelable> Bundle.getParcelableOrNull(key: String): T? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun <reified T : Serializable> Bundle.requireSerializable(key: String): T = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun <reified T : Serializable> Bundle.getSerializableOrNull(key: String): T? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Bundle.requireImpl(key: String): T {
    if (key !in this) {
        throw IllegalArgumentException("Bundle has no key $key")
    }
    return get(key) as? T ?: throw IllegalStateException("Wrong type found in Bundle for key $key")
}

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Bundle.getOrNullImpl(key: String): T? {
    if (key !in this) {
        return null
    }
    return get(key) as? T?
}

/**
 * Check if [this] Bundle contains the given [key].
 */
@PublishedApi
internal inline operator fun Bundle.contains(key: String): Boolean = containsKey(key)
