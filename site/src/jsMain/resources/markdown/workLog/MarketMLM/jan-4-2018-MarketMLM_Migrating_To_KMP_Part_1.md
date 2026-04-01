## jan-4-2018-Migrating-To-KMP

- We found the idea of Kotlin Multipalform very fascinating. currently our platform was only targeting Android and we did not have a ios application. this was a great oppertunety to target ios with minmum refactoring.

At first we knew that Kotlin multiplatform was in its early stages, many dependencies was not supported at the current time. first we must figure out whetch dep that we used is not compatable with KMP at this time.

Second, the early stages problem was also applicable for CMP. But because we used jetpack Compose and androidx , we did not find huge usecase that we needed to change in order to migrate with CMP. Two dependencies was not compatable: Ballon for showing toasts and Glide for image loading.

For cmp deps, we deside to get rid of Ballon and create a custom one using compose. for Glide we switched to camel.


For the KMP side almost all we used was compatable with KMP except our Database, we used realm and KMP was only supporting a new kind of DB called SQLDlight. Refactoring this section was not so challenging. The Dao was basiclly the same,the data models was the most different. while realm was using kotlin data class, sqldelight was using a custom yaml file.