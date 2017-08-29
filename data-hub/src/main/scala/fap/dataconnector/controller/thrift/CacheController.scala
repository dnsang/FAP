package fap.dataconnector.controller.thrift

import javax.inject.{Inject, Singleton}

import com.twitter.finagle.Service
import com.twitter.finatra.thrift.Controller
import com.twitter.inject.Logging
import com.twitter.util.Future
import fap.dataconnector.service.TUserCacheService.{AddUser, GetUser}
import fap.dataconnector.service.TUserCacheService.AddUser.{Args, Result}
import fap.dataconnector.service.TUserCacheService.GetUser.{Args, Result}
import fap.dataconnector.service.{TUserCacheService, UserCacheService}
import fap.dataconnector.domain.ThriftImplicit.{T2UserId, T2UserInfo, UserInfo2T, UserId2T,Future2T}

/**
  * Created by SangDang on 9/16/16.
  */
@Singleton
class CacheController @Inject()(cacheService: UserCacheService) extends Controller with TUserCacheService.BaseServiceIface with Logging {
  override val addUser = handle(AddUser) { args: AddUser.Args => {
    Future.value(cacheService.addUser(args.userInfo.userId, args.userInfo))
  }

  }
  override val getUser = handle(GetUser) { args: GetUser.Args => {
    cacheService.getUser(args.userId)
  }
  }
}
